package com.dcs.productivityapp.Activities

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dcs.productivityapp.Controller.ToDoAdapter
import com.dcs.productivityapp.Model.Note
import com.dcs.productivityapp.Model.ToDoModel
import com.dcs.productivityapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_note_listing.view.*
import kotlinx.android.synthetic.main.activity_todo_listing.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.collections.ArrayList

class TodoListing : AppCompatActivity() {


    private var recentTodoId: String?=""
    private var layoutManager2: RecyclerView.LayoutManager? = null
    private var ToDoAdapter: ToDoAdapter? = null
    private var todoList: MutableList<ToDoModel>? = null
    private var todoListItems: ArrayList<ToDoModel>? = null

    private var currentUser= FirebaseAuth.getInstance().currentUser

    private val todosDocRef= Firebase.firestore.collection("users")
        .document(currentUser!!.uid)
        .collection("todos")

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_listing)

        layoutManager2= LinearLayoutManager(this)
        todoList= ArrayList()
        todoListItems= ArrayList()

        ToDoAdapter= ToDoAdapter(todoListItems!!,this)
        getTodos()

        for (todos in todoListItems!!){
            Log.d("In: ",todos.itemDataText!!)
        }

        item_listView.layoutManager=layoutManager2
        item_listView.adapter= ToDoAdapter

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton

        fab.setOnClickListener { view ->
            val alertDialog = AlertDialog.Builder(this)
            val textEditText = EditText(this)
            alertDialog.setMessage("Add TODO item")
            alertDialog.setTitle("Enter To Do item")
            alertDialog.setView(textEditText)
            alertDialog.setPositiveButton("Add") { dialog, i ->
                createTodo(textEditText)
            }
            alertDialog.show()
        }

    }

        toDOList = mutableListOf<ToDoModel>()
        adapter = ToDoAdapter(this, toDOList!!)
        listViewItem!!.adapter = adapter
        database.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(applicationContext, "No itemAdded", Toast.LENGTH_LONG).show()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                toDOList!!.clear()
                addItemToList(snapshot)
            }

        })
    }



private fun addItemToList(snapshot: DataSnapshot) {

    val items=snapshot.children.iterator()

    if(items.hasNext()){
        val toDoIndexedValue=items.next()
        val itemsIterator=toDoIndexedValue.children.iterator()

        while(itemsIterator.hasNext()){
            val currentItem=itemsIterator.next()
            val toDoItemData=ToDoModel.createList()
            val map=currentItem.getValue() as HashMap<String, Any>

            toDoItemData.UID=currentItem.key
            toDoItemData.done=map.get("done") as Boolean?
            toDoItemData.itemDataText=map.get("itemDataText") as String?
            toDOList!!.add(toDoItemData)
        }

    }

    adapter.notifyDataSetChanged()

}

override fun modifyItem(itemUID: String, isDone: Boolean) {
    val itemReference=database.child("todo").child(itemUID)
    itemReference.child("done").setValue(isDone)
}

override fun onItemDelete(itemUID: String) {
    val itemReference=database.child("todo").child(itemUID)
    itemReference.removeValue()
    adapter.notifyDataSetChanged()
}


}



