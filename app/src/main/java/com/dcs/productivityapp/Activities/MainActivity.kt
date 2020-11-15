package com.dcs.productivityapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import com.dcs.productivityapp.Model.User
import com.dcs.productivityapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header.*
import com.google.firebase.database.ValueEventListener as ValueEventListener1

class MainActivity : AppCompatActivity() {

//    var user:FirebaseUser?=null
//    private var dbref:DatabaseReference?=null
//
//    var userId:String?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var user = FirebaseAuth.getInstance().currentUser
        var dbref = FirebaseDatabase.getInstance().getReference("users")
        var userId = user?.uid

        dbref.child(userId!!).addListenerForSingleValueEvent(object : ValueEventListener1 {
            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(p0: DataSnapshot) {
                val userProfile: User? =p0.getValue(User::class.java)



                if (userProfile!=null) {
                    val name = userProfile.name
                    val email = userProfile.email

                    userName.text = name
                    userEmail.text = email

                    usersName.text = name
                    usersEmail.text = email
                }
            }
        })

        imageMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.notes -> {
                    val i=Intent(this,NoteListing::class.java)
                    startActivity(i)
                }
                R.id.todo -> {
                    val i=Intent(this,TodoListing::class.java)
                    startActivity(i)
                }
                R.id.habits -> {

                }
                R.id.contact -> {
                    val i=Intent(this,Contact::class.java)
                    startActivity(i)
                }
                R.id.logout -> {
                    FirebaseAuth.getInstance().signOut()
                    val i=Intent(this,LoginActivity::class.java)
                    i.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(i)
                }
            }
            true
        }

    }

    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
