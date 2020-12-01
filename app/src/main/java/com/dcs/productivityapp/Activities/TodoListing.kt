package com.dcs.productivityapp.Activities

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.dcs.productivityapp.Controller.ToDoAdapter
import com.dcs.productivityapp.Model.ToDoModel
import com.dcs.productivityapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class TodoListing : AppCompatActivity() ,UpdateAndDelete {

    lateinit var database: DatabaseReference
    var toDOList: MutableList<ToDoModel>? = null
    lateinit var adapter: ToDoAdapter
    private var listViewItem: ListView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_listing)

        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        listViewItem = findViewById<ListView>(R.id.item_listView)

        database = FirebaseDatabase.getInstance().reference

        fab.setOnClickListener { view ->
            val alertDialog = AlertDialog.Builder(this)
            val textEditText = EditText(this)
            alertDialog.setMessage("Add TODO item")
            alertDialog.setTitle("Enter To Do item")
            alertDialog.setView(textEditText)
            alertDialog.setPositiveButton("Add") { dialog, i ->
                val todoItemData = ToDoModel.createList()
                todoItemData.itemDataText = textEditText.text.toString()
                todoItemData.done = false

                val newItemData = database.child("todo").push()
                todoItemData.UID = newItemData.key

                newItemData.setValue(todoItemData)
                dialog.dismiss()
                Toast.makeText(this, "item saved", Toast.LENGTH_LONG).show()
            }
            alertDialog.show()
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



