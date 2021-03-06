package com.dcs.productivityapp.Activities

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.dcs.productivityapp.Model.Habits
import com.dcs.productivityapp.Model.Note
import com.dcs.productivityapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_habit_sum.*
import kotlinx.android.synthetic.main.activity_note_creation.*
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import java.lang.Math.abs
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
class HabitSum : AppCompatActivity() {

    private val currentUser = FirebaseAuth.getInstance().currentUser
    private val notesDocRef = Firebase.firestore.collection("users")
        .document(currentUser!!.uid)
        .collection("habits")
    private var exists = false
    private var habitId = ""

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit_sum)

        if (intent.hasExtra("habitId")) {

            exists = true
            val data: Bundle? = intent.extras
            habitId = data?.getString("habitId").toString()

            getClickedHabit()

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getClickedHabit(): Job = CoroutineScope(Dispatchers.IO).launch {
        try {
            val querySnapshot = notesDocRef.whereEqualTo("id", habitId).get().await()
            var habit = Habits()
            for (doc in querySnapshot.documents) {
                //habits
                habit= doc.toObject<Habits>()!!

            }
            withContext(Dispatchers.Main) {
                val formatter =  DateTimeFormatter.ofPattern("yyyy.MM.dd")
                val day = LocalDate.parse(habit.creationDate, formatter)
                val diff = ChronoUnit.DAYS.between(LocalDate.now(),day)
                Log.d("diff",diff.toString())

                progressBar.setMax(abs((Math.ceil(diff.toDouble()).toInt())))
                Log.d("diff",Math.ceil(diff.toDouble()).toInt().toString())

                progressBar.setMin(0)
                progressBar.setProgress(habit.days)
                progressBar.setVisibility(VISIBLE)
                habitTitle.setText(habit.itemDataText)
                habitDate.setText(habit.creationDate)
                habitdays.setText(habit.days.toString())

            }
        } catch (e: Exception) {
            Log.e("Error: ", e.message)
        }
    }

}


