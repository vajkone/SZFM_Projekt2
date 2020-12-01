package com.dcs.productivityapp.Controller

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Build.ID
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.dcs.productivityapp.Activities.TodoListing
import com.dcs.productivityapp.Activities.UpdateAndDelete
import com.dcs.productivityapp.Model.ToDoModel
import com.dcs.productivityapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.row_itemslayout.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class ToDoAdapter(private var list: MutableList<ToDoModel>, private val context: Context):
    androidx.recyclerview.widget.RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    private var currentUser= FirebaseAuth.getInstance().currentUser
    private val todosDocRef= Firebase.firestore.collection("users")
        .document(currentUser!!.uid)
        .collection("todos")


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        fun bindTodo(todo: ToDoModel){

            val todoTitle = itemView.findViewById(R.id.item_textView) as TextView
            val todoDeleteButton: ImageButton =itemView.findViewById(R.id.close) as ImageButton
            val isDone: CheckBox =itemView.findViewById(R.id.checkbox) as CheckBox

            todoTitle.text=todo.itemDataText
            isDone.isChecked = todo.done!!

            todoDeleteButton.setOnClickListener {

                val builder = AlertDialog.Builder(context)
                builder.setMessage("Are you sure you want to Delete?")
                    .setTitle("Warning!")
                    .setPositiveButton("Yes", DialogInterface.OnClickListener{ dialog, wich ->
                        deleteTodo(todo)
                        val a = adapterPosition
                        list.removeAt(a)
                        notifyItemRemoved(adapterPosition)

                    })
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialog, wich ->
                        // User cancelled the dialog
                    })
                    .show()

                builder.create()

            }

            isDone.setOnClickListener{
                val todo2=updatedTodo(todo)
                updateTodo(todo2!!)

            }

        }

        private fun deleteTodo(todo: ToDoModel)= CoroutineScope(Dispatchers.IO).launch {
            var currentUser= FirebaseAuth.getInstance().currentUser

            val notesDocRef= Firebase.firestore.collection("users")
                .document(currentUser!!.uid)
                .collection("todos")


            val noteQuery = notesDocRef
                .whereEqualTo("id",todo.ID)
                .get()
                .await()

     if (noteQuery.documents.isNotEmpty()){
                for (doc in noteQuery){
                    try {
                        notesDocRef.document(doc.id).delete().await()
                    }catch (e: Exception){
                        Log.e("Error: ",e.message)
                    }
                }
            }
        }
    }

    private fun updatedTodo(todos: ToDoModel): ToDoModel? {
        var todo=ToDoModel()
        todo.itemDataText=todos?.itemDataText
        todo.ID=todos.ID
        todo.done=!todos?.done!!

        return todo

    }

    private fun updateTodo(todo: ToDoModel)= CoroutineScope(Dispatchers.IO).launch {

        val noteQuery=todosDocRef
            .whereEqualTo("id",todo.ID)
            .get()
            .await()

        if (noteQuery.documents.isNotEmpty()){
            for (doc in noteQuery){
                try {
                    todosDocRef.document(doc.id).set(todo, SetOptions.merge())

                }catch (e:Exception){
                    Log.e("error: ",e.message)
                }
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_itemslayout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTodo(list[position])
    }

    override fun getItemCount(): Int {
        return  list.size
    }



}


