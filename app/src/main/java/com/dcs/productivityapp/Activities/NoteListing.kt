package com.dcs.productivityapp.Activities

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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
import kotlinx.android.synthetic.main.search_card.*
import kotlinx.android.synthetic.main.search_card.view.*
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
    private var sortedByTitle = false
    private var sortedByDate = false
    private var view: View? = null
    private var dialog: AlertDialog? = null

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

        alphaBtn.setOnClickListener {
            if (sortedByTitle){
                noteListItems!!.reverse()
            }else {
                var sortedlist = noteListItems!!.sortedWith(compareBy { it.noteTitle })
                noteListItems!!.clear()
                for (li in sortedlist) {
                    noteListItems!!.add(li)
                }
            }
            noteListAdapter!!.notifyDataSetChanged()
            sortedByTitle=true
        }

        dateBtn.setOnClickListener {
            if (sortedByDate){
                noteListItems!!.reverse()
            }else {
                var sortedlist = noteListItems!!.sortedWith(compareBy { it.noteDate })
                noteListItems!!.clear()
                for (li in sortedlist) {
                    noteListItems!!.add(li)
                }
            }
            noteListAdapter!!.notifyDataSetChanged()
            sortedByDate=true
        }

        defaultList.setOnClickListener {

            noteListItems!!.clear()
            getNotes()
        }

        search.setOnClickListener {

            view = View.inflate(this, R.layout.search_card, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(view)

            dialog = builder.create()
            dialog!!.show()
            dialog!!.window?.setBackgroundDrawableResource(android.R.color.transparent)

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

    fun onSearchClicked(v: View){
        val titlesearch=view!!.titleSearch.text.toString()

        val labelsearch=view!!.labelSearch.text.toString()
        val textsearch=view!!.textSearch.text.toString()
        Log.d("searching by tag:",titlesearch)
        var searchlist=searchByTitle(titlesearch)
        searchlist.plusAssign(searchByLabel(labelsearch))
        searchlist.plusAssign(searchByText(textsearch))

        noteListItems!!.clear()
        for (li in searchlist){
            noteListItems!!.add(li)
        }



        noteListAdapter!!.notifyDataSetChanged()
        dialog!!.dismiss()


    }

    private fun searchByTitle(title: String): ArrayList<Note> {
        var listofnotesbytitle= ArrayList<Note>()
        if (!title.isBlank()) {
            for (li in noteListItems!!) {
                if (li.noteTitle!!.contains(title))
                    listofnotesbytitle.add(li)

            }
        }
        return listofnotesbytitle
    }

    private fun searchByText(text: String): ArrayList<Note> {
        var listofnotesbytitle= ArrayList<Note>()
        if (!text.isBlank()) {
            for (li in noteListItems!!) {
                if (li.text!!.contains(text))
                    listofnotesbytitle.add(li)

            }
        }
        return listofnotesbytitle
    }


    private fun searchByLabel(label: String): ArrayList<Note> {

        var listofnotesbylabel= ArrayList<Note>()
        if (!label.isBlank()) {
            for (li in noteListItems!!) {
                if (li.noteLabel!!.contains(label))
                    listofnotesbylabel.add(li)

            }
        }
        return listofnotesbylabel


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