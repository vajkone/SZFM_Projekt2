package com.dcs.productivityapp.Activities

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.dcs.productivityapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() ,UpdateAndDelete {

    lateinit var database: DatabaseReference
    var toDOList:MutableList<ToDoModel>?=null
    lateinit var adapter: ToDoAdapter
    private var listViewItem: ListView?=null

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_listing)

        val fab=findViewById<View>(com.google.firebase.database.R.id.fab) as FloatingActionButton
        listViewItem=findViewById<ListView>(com.google.firebase.database.R.id.item_listView)

        database=FirebaseDatabase.getInstance().reference

        fab.setOnClickListener{view ->
            val alertDialog=AlertDialog.Builder(this)
            val textEditText=EditText(this)
            alertDialog.setMessage("Add TODO item")
            alertDialog.setTitle("Enter To Do item")
            alertDialog.setView(textEditText)
            alertDialog.setPositiveButton("Add"){dialog, i ->
                val todoItemData=ToDoModel.createList()
                todoItemData.itemDataText=textEditText.text.toString()
                todoItemData.done=false

                val newItemData=database.child("todo").push()
                todoItemData.UID=newItemData.key

                newItemData.setValue(todoItemData)
                dialog.dismiss()
                Toast.makeText(this,"item saved",Toast.LENGTH_LONG).show()
            }
            alertDialog.show()
        }
    }

}