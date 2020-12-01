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

    private fun createTodo(s: EditText) {

        var todo = ToDoModel()


        todo.itemDataText = s.text.toString()
        todo.ID = todosDocRef.document().id
        todo.done = false
        Toast.makeText(this, todo.itemDataText, Toast.LENGTH_LONG).show()

        Log.d("Note id: ",todo.ID!!)

        if (todo.itemDataText == "") {
            Toast.makeText(applicationContext, "Please enter a title", Toast.LENGTH_SHORT).show()

        } else {
            saveTodo(todo)
            todoListItems?.clear()
            getTodos()
            ToDoAdapter!!.notifyDataSetChanged()

        }
    }