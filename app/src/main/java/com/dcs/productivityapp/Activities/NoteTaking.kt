package com.dcs.productivityapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.dcs.productivityapp.Model.Note
import com.dcs.productivityapp.Model.User
import com.dcs.productivityapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.Tag
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_note_taking.*
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class NoteTaking : AppCompatActivity() {


    private val userCollectionRef=Firebase.firestore.collection("users")
    private val currentUser=FirebaseAuth.getInstance().currentUser
    private val notesDocRef=Firebase.firestore.collection("users")
        .document(currentUser!!.uid)
        .collection("notes")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_taking)

        addme.setOnClickListener {

            val note= Note()
            note.cues="Bruh lol"
            note.labels=ArrayList()
            note.labels!!.add("Asd")
            note.labels!!.add("Haha")
            note.summary="Well this is completely splendid"
            note.text="Let's create a simple example of ArrayList class define with empty " +
                    "ArrayList of String and add elements later."
            note.title="Cool, cool"

            saveNote(note)

        }




    }

    private fun saveNote(note: Note)= CoroutineScope(Dispatchers.IO).launch{

        try {
            notesDocRef.add(note).await()
            Toast.makeText(this@NoteTaking,"Data uploaded",Toast.LENGTH_LONG).show()

        }catch (e: Exception){
            withContext(Dispatchers.Main){
                Toast.makeText(this@NoteTaking,e.message,Toast.LENGTH_LONG).show()
            }
        }
    }
}