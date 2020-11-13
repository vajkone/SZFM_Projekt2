package com.dcs.productivityapp.Activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dcs.productivityapp.Controller.NoteListAdapter
import com.dcs.productivityapp.Model.Note
import com.dcs.productivityapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_note_listing.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception

class NoteListing : AppCompatActivity() {

    private var recentNoteId: String?=""
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var noteListAdapter: NoteListAdapter? = null
    private var noteList: MutableList<Note>? = null
    private var noteListItems: ArrayList<Note>? = null
    private var currentUser= FirebaseAuth.getInstance().currentUser

    private val notesDocRef= Firebase.firestore.collection("users")
        .document(currentUser!!.uid)
        .collection("notes")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_listing)



        layoutManager= LinearLayoutManager(this)
        noteList= ArrayList()
        noteListItems= ArrayList()


        noteListAdapter= NoteListAdapter(noteListItems!!,this)
        getNotes()

        for (notes in noteListItems!!){
            Log.d("In: ",notes.noteTitle!!)
        }

        noteListRecView.layoutManager=layoutManager
        noteListRecView.adapter=noteListAdapter




        addNewNote.setOnClickListener {
            val intent = Intent(this,NoteTaking::class.java)
            startActivityForResult(intent,1)
        }
    }

    private fun getNotes()= CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot=notesDocRef.get().await()

            for (doc in querySnapshot.documents) {

                val note = doc.toObject<Note>()
                noteListItems!!.add(note!!)
                Log.d("Added note: ","${note.noteTitle}")
            }
            withContext(Dispatchers.Main){
                noteListAdapter!!.notifyDataSetChanged()
            }

        }catch (e: Exception){
            Log.e("Error: ",e.message)
        }
    }

    private fun getNoteById(id:String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot = notesDocRef.whereEqualTo("id", id).get().await()



            for (doc in querySnapshot.documents) {

                val note = doc.toObject<Note>()
                noteListItems!!.add(note!!)
                Log.d("Added note: ","${note.noteTitle}")
            }
            withContext(Dispatchers.Main){

                noteListAdapter!!.notifyDataSetChanged()

            }
        }catch (e:Exception){
            Log.e("Error: ",e.message)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode== Activity.RESULT_OK){
            recentNoteId = data!!.getStringExtra("recentNoteID")
            getNoteById(recentNoteId!!)
            noteListAdapter!!.notifyDataSetChanged()

        }


    }
}