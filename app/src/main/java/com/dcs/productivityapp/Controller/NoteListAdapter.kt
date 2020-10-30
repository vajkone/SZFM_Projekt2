package com.dcs.productivityapp.Controller

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dcs.productivityapp.Activities.NoteTaking
import com.dcs.productivityapp.Model.Note
import com.dcs.productivityapp.R

class NoteListAdapter(private var list: MutableList<Note>, private val context: Context):
    androidx.recyclerview.widget.RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindNote(note: Note){

            val noteTitle = itemView.findViewById(R.id.noteTitle) as TextView
            val noteLabel = itemView.findViewById(R.id.noteLabels) as TextView
            val noteDate: TextView =itemView.findViewById(R.id.noteDate)
            val noteDeleteButton: TextView = itemView.findViewById(R.id.noteDeleteButton)

            noteTitle.text=note.noteTitle
            noteLabel.text=note.noteLabel
            noteDate.text=note.noteDate


            noteDeleteButton.setOnClickListener {

                val builder = AlertDialog.Builder(context)
                builder.setMessage("Are you sure you want to Delete?")
                    .setTitle("Warning!")
                    .setPositiveButton("Yes", DialogInterface.OnClickListener{ dialog, wich ->
                       TODO("Implement cloud remove function")
//                        val a = adapterPosition
//                        list.removeAt(a)
//                        notifyItemRemoved(adapterPosition)
                    })
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialog, wich ->
                        // User cancelled the dialog
                    })
                    .show()

                builder.create()

            }

            itemView.setOnClickListener {

                val intent = Intent(context, NoteTaking::class.java)
                intent.putExtra("noteId",note.id)
                Log.d("NoteId: ",note.id)
                context.startActivity(intent)

            }

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteListAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.note_card,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: NoteListAdapter.ViewHolder, position: Int) {
        holder.bindNote(list[position])
    }

}