package com.dcs.productivityapp.Activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dcs.productivityapp.Controller.HabitListAdapter
import com.dcs.productivityapp.Model.Habits
import com.dcs.productivityapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_habits_listing.*
import kotlinx.android.synthetic.main.activity_note_creation.*
import kotlinx.android.synthetic.main.activity_note_listing.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HabitsListing : AppCompatActivity() {
    private var recentHabitId: String? = ""
    private var layoutManager2: RecyclerView.LayoutManager? = null

    private var habitListAdapter: HabitListAdapter? = null
    private var habitList: MutableList<Habits>? = null
    private var habitListItems: ArrayList<Habits>? = null


    private var currentUser = FirebaseAuth.getInstance().currentUser

    private val notesDocRef = Firebase.firestore.collection("users")
        .document(currentUser!!.uid)
        .collection("habits")


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {


        layoutManager2 = LinearLayoutManager(this)
        habitList = ArrayList()
        habitListItems = ArrayList()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habits_listing)

        val textView: TextView = findViewById(R.id.today)
        val today = LocalDate.now()
        val form = "MM.dd"


        val formattedToday = today.format(DateTimeFormatter.ofPattern(form))
        textView.text = formattedToday


        val textView2: TextView = findViewById(R.id.yesterday)
        val tomorrow = LocalDate.now().minusDays(1)
        val formattedTomorrow = tomorrow.format(DateTimeFormatter.ofPattern(form))
        textView2.text = formattedTomorrow

        val textView3: TextView = findViewById(R.id.before_yesterday)
        val beTomorrow = LocalDate.now().minusDays(2)
        val formattedbeTomorrow = beTomorrow.format(DateTimeFormatter.ofPattern(form))
        textView3.text = formattedbeTomorrow

        habitListAdapter = HabitListAdapter(habitListItems!!, this)
        getHabits()



        for (habit in habitListItems!!){
            Log.d("In: ",habit.itemDataText)
        }

        habitListRecView.layoutManager=layoutManager2
        habitListRecView.adapter=habitListAdapter


        val fabhabit = findViewById<View>(R.id.fabhabit) as FloatingActionButton



        fabhabit.setOnClickListener { view ->
            val alertDialog = AlertDialog.Builder(this)
            val textEditText = EditText(this)
            alertDialog.setMessage("Add habit to list")
            alertDialog.setTitle("Enter Habit")
            alertDialog.setView(textEditText)
            alertDialog.setPositiveButton("Add") { dialog, i ->
                createHabit(textEditText)

            }
            alertDialog.show()

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createHabit(s: EditText) {

        val today = LocalDate.now()
        val form = "yyyy.MM.dd"


        val formattedToday = today.format(DateTimeFormatter.ofPattern(form))


        var habit = Habits()


        habit.itemDataText = s.text.toString()
        habit.ID = notesDocRef.document().id
        habit.done = false
        habit.done3 = false
        habit.done3 = false
        habit.checkDate = formattedToday
        habit.creationDate = formattedToday
        habit.days = 0
        Toast.makeText(this,habit.itemDataText,Toast.LENGTH_LONG).show()



        if(habit.itemDataText==""){
            Toast.makeText(applicationContext, "Please enter a title", Toast.LENGTH_SHORT).show()

        }else{
            saveHabit(habit)
            setContentView(R.layout.activity_habits_listing)
          val intent = Intent()
         intent.putExtra("recentHabitID", habit.ID!!)
          setResult(RESULT_OK, intent)
          finish()
      }


    }

    private fun saveHabit(habit: Habits)= CoroutineScope(Dispatchers.IO).launch{

            try {



                notesDocRef.add(habit).await()
                //Toast.makeText(this@NoteTaking,"Data uploaded",Toast.LENGTH_LONG).show()
                Log.d("Data: ","Uploaded")

            }catch (e: Exception){
                withContext(Dispatchers.Main){
                    Log.d("Data: ","Not Uploaded")
                    Log.e("error",e.toString())
                }
            }

    }


    private fun getHabits()= CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot=notesDocRef.get().await()

            for (doc in querySnapshot.documents) {

                val habit : Habits? = doc.toObject<Habits>()
                habitListItems!!.add(habit!!)
                Log.d("Added note: ","${habit.itemDataText}")
            }
            withContext(Dispatchers.Main){
                habitListAdapter!!.notifyDataSetChanged()
            }

        }catch (e: Exception){
            Log.e("Error: ",e.message)
        }
    }

}
