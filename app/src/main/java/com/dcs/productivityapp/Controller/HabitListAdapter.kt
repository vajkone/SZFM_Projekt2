package com.dcs.productivityapp.Controller

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.dcs.productivityapp.Activities.HabitSum
import com.dcs.productivityapp.Activities.NoteTaking
import com.dcs.productivityapp.Model.Habits
import com.dcs.productivityapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.SetOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_note_creation.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


private val habitID : String? = ""
class HabitListAdapter (private var list: MutableList<Habits>, private val context: Context):
    androidx.recyclerview.widget.RecyclerView.Adapter<HabitListAdapter.ViewHolder>(){
    private var habitID : String? = ""
    private val currentUser=FirebaseAuth.getInstance().currentUser
    private val habitsDocRef=Firebase.firestore.collection("users")
        .document(currentUser!!.uid)
        .collection("habits")


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {


        @RequiresApi(Build.VERSION_CODES.O)
        fun bindHabit(habit : Habits ){

            val habitTitle = itemView.findViewById(R.id.item_textViewHabit) as TextView
            val isDone: CheckBox =itemView.findViewById(R.id.checkboxh1) as CheckBox
            val isDone2: CheckBox =itemView.findViewById(R.id.checkboxh2) as CheckBox
            isDone2.isEnabled= false
            val isDone3: CheckBox =itemView.findViewById(R.id.checkboxh3) as CheckBox
            isDone3.isEnabled = false
            val DeleteButton: ImageButton =itemView.findViewById(R.id.close) as ImageButton


            val formatter =  DateTimeFormatter.ofPattern("yyyy.MM.dd")
            val form = "yyyy.MM.dd"
            val day = LocalDate.parse(habit.checkDate, formatter)

            val daycomp : LocalDate = LocalDate.now()
            val daycomp2 : String = daycomp.format(DateTimeFormatter.ofPattern(form))
            val finalday : LocalDate = LocalDate.parse(daycomp2,formatter)
            Log.d("days",habit.checkDate)
            Log.d("days",daycomp2)

            if ( finalday > day){
                val habitslide : Habits? = slideHabbit(habit)
                updateHabit(habitslide!!)
            }

            habitTitle.text =  habit.itemDataText
            isDone.isChecked = habit.done!!
            isDone2.isChecked = habit.done2!!
            isDone3.isChecked = habit.done3 !!

            DeleteButton.setOnClickListener {

                val builder = AlertDialog.Builder(context)
                builder.setMessage("Are you sure you want to Delete?")
                    .setTitle("Warning!")
                    .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, wich ->
                        deleteHabit(habit)
                        val a = adapterPosition
                        list.removeAt(a)
                        notifyItemRemoved(adapterPosition)

                    })
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, wich ->
                        // User cancelled the dialog
                    })
                    .show()

                builder.create()

            }

            isDone.setOnClickListener {
                val habit2=updatedHabit(
                    habit)
                updateHabit(habit2!!)
            }
            itemView.setOnClickListener {

                val intent = Intent(context, HabitSum::class.java)
                intent.putExtra("habitId",habit.ID)

                context.startActivity(intent)

            }
        }
    }

    private fun deleteHabit(habit: Habits)= CoroutineScope(Dispatchers.IO).launch {
        var currentUser= FirebaseAuth.getInstance().currentUser

        val notesDocRef= Firebase.firestore.collection("users")
            .document(currentUser!!.uid)
            .collection("habits")


        val noteQuery = notesDocRef
            .whereEqualTo("id",habit.ID)
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



    private fun updatedHabit(habitin : Habits? ): Habits? {

        var habit = Habits()
        habit.itemDataText = habitin?.itemDataText
        habit.done = !habitin?.done!!
        habit.done2 = habitin.done2!!
        habit.done3 = habitin.done3!!
        habit.ID = habitin.ID
        habit.checkDate = habitin.checkDate
        habit.days = habitin.days+1
        habit.creationDate = habitin.creationDate
        Log.d("SUCCES",habitin.done.toString())
        Log.d("SUCCES",habit.done.toString())

        return habit



    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun slideHabbit(habitin : Habits? ): Habits? {
        var seged : Boolean = false
        val today = LocalDate.now()
        val form = "yyyy.MM.dd"

        val formattedToday = today.format(DateTimeFormatter.ofPattern(form))
        var habit = Habits()
        habit.itemDataText = habitin?.itemDataText
        seged = habitin!!.done2!!

        habit.done2 = habitin!!.done!!
        habit.creationDate = habitin.creationDate
        habit.done = false
        habit.done3 = seged!!
        habit.ID = habitin!!.ID
        habit.checkDate = formattedToday
        habit.days = habitin.days


        Log.d("SUCCES",habitin.done.toString())
        Log.d("SUCCES",habit.done.toString())

        return habit



    }


    private fun updateHabit(habit:Habits)= CoroutineScope(Dispatchers.IO).launch {

        val noteQuery=habitsDocRef
            .whereEqualTo("id",habit.ID)
            .get()
            .await()

        if (noteQuery.documents.isNotEmpty()){
            for (doc in noteQuery){
                try {
                    Log.d("SUCCES",habit.done.toString())
                    habitsDocRef.document(doc.id).set(habit,SetOptions.merge())

                    Log.d("SUCCES",doc.id)
                    Log.d("SUCCES",habit.ID)
                    Log.d("SUCCES",habit.done.toString())


                }catch (e:Exception){
                    Log.e("error: ",e.message)
                }
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitListAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_itemslayout_habit,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  list.size
    }



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: HabitListAdapter.ViewHolder, position: Int) {
        holder.bindHabit(list[position])
    }


}