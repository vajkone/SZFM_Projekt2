package com.dcs.productivityapp.Activities

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.dcs.productivityapp.Model.Note
import com.dcs.productivityapp.Model.User
import com.dcs.productivityapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.Tag
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_note_creation.*
import kotlinx.android.synthetic.main.activity_note_taking.*
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import java.util.*
import kotlin.collections.HashMap

class NoteTaking : AppCompatActivity() {


    private val userCollectionRef=Firebase.firestore.collection("users")
    private val currentUser=FirebaseAuth.getInstance().currentUser
    private val notesDocRef=Firebase.firestore.collection("users")
        .document(currentUser!!.uid)
        .collection("notes")
    private var exists=false
    private var noteId=""







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_creation)

        if (intent.hasExtra("noteId")){

            exists=true
            val data:Bundle? = intent.extras
            noteId = data?.getString("noteId").toString()
            Log.d("noteID:",noteId)
            getClickedNote()

        }

        saveNote.setOnClickListener {
            if (exists){
                val newNote=updatedNote()
                updateNote(newNote!!,noteId)
                finish()
            }else {
                createNote()
            }
        }






    }

    private fun getClickedNote(): Job = CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot = notesDocRef.whereEqualTo("id", noteId).get().await()
            var note=Note()
            for (doc in querySnapshot.documents) {

                 note= doc.toObject<Note>()!!

                Log.d("Added note: ","${note.noteTitle}")
            }
            withContext(Dispatchers.Main){
                noteTitle.setText(note.noteTitle, TextView.BufferType.EDITABLE)
                noteLabels.setText(note.noteLabel, TextView.BufferType.EDITABLE)
                noteTextCue.setText(note.cue, TextView.BufferType.EDITABLE)
                noteTextText.setText(note.text, TextView.BufferType.EDITABLE)
                noteTextSummary.setText(note.summary, TextView.BufferType.EDITABLE)
            }
        }catch (e:Exception){
            Log.e("Error: ",e.message)
        }
    }

    private fun createNote() {
        val d = Date()
        val s = DateFormat.format("yyyy. MM. dd. HH:mm:ss", d)
        val sd = s.toString()

        var note = Note()


        note.noteTitle = noteTitle.text.toString()
        note.noteDate = sd
        note.noteLabel = noteLabels.text.toString()
        note.cue = noteTextCue.text.toString()
        note.summary = noteTextSummary.text.toString()
        note.text = noteTextText.text.toString()
        note.id=notesDocRef.document().id

        Log.d("Note id: ",note.id!!)



        if(note.noteTitle==""){
            Toast.makeText(applicationContext, "Please enter a title", Toast.LENGTH_SHORT).show()

        }else{
            saveNote(note)
            val intent = Intent()
            intent.putExtra("recentNoteID", note.id!!)
            setResult(RESULT_OK, intent)
            finish()
        }


    }

    private fun updatedNote(): Note? {


        val d = Date()
        val s = DateFormat.format("yyyy. MM. dd. HH:mm:ss", d)
        val sd = s.toString()


        var note = Note()
        note.noteTitle = noteTitle.text.toString()
        note.noteDate=sd
        note.noteLabel = noteLabels.text.toString()
        note.cue = noteTextCue.text.toString()
        note.summary = noteTextSummary.text.toString()
        note.text = noteTextText.text.toString()
        note.id=noteId


        Log.d("Note id: ",note.id!!)



        if(note.noteTitle==""){
            Toast.makeText(applicationContext, "Please enter a title", Toast.LENGTH_SHORT).show()

        }else{
            return note
        }
        return null

    }

    private fun updateNote(note:Note,noteId:String)= CoroutineScope(Dispatchers.IO).launch {

        val noteQuery=notesDocRef
            .whereEqualTo("id",noteId)
            .get()
            .await()

        if (noteQuery.documents.isNotEmpty()){
            for (doc in noteQuery){
                try {
                    notesDocRef.document(doc.id).set(note, SetOptions.merge())

                }catch (e:Exception){
                    Log.e("error: ",e.message)
                }
            }
        }

    }



    private fun saveNote(note: Note)= CoroutineScope(Dispatchers.IO).launch{

        try {


            notesDocRef.add(note).await()
            //Toast.makeText(this@NoteTaking,"Data uploaded",Toast.LENGTH_LONG).show()
            Log.d("Data: ","Uploaded")

        }catch (e: Exception){
            withContext(Dispatchers.Main){
                Log.d("Data: ","Not Uploaded")
            }
        }
    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Do you want to save it?")
            .setTitle("Warning!")
            .setPositiveButton("Yes", DialogInterface.OnClickListener{ dialog, wich ->
                if (exists){
                    val newNote=updatedNote()
                    updateNote(newNote!!,noteId)
                }else{
                    createNote()
                }
            })
            .setNegativeButton("No", DialogInterface.OnClickListener{ dialog, wich ->
                setResult(Activity.RESULT_CANCELED, intent)
                finish()
            })
            .show()

        builder.create()

    }


}