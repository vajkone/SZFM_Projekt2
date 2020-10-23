package com.dcs.productivityapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dcs.productivityapp.Model.User
import com.dcs.productivityapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_signup.*

private var mAuth: FirebaseAuth? = null


class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        mAuth=FirebaseAuth.getInstance()

        signUpBtn.setOnClickListener {

            val email=signUpEmail.text.toString()
            val password=signUpPassword.text.toString()
            val name=signUpName.text.toString()
            val age="25";

            progressBarSignup.visibility= View.VISIBLE
            mAuth!!.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        val user = User(name,email,age)
                        FirebaseDatabase.getInstance().getReference("users")
                            .child(FirebaseAuth.getInstance().currentUser!!.uid).setValue(user)
                            .addOnCompleteListener {task ->

                                if (task.isSuccessful){
                                    Toast.makeText(this,"User has been registered",Toast.LENGTH_LONG).show()
                                    progressBarSignup.visibility=View.GONE
                                }else{
                                    Toast.makeText(this,"Something went wrong, failed to register",Toast.LENGTH_LONG).show()
                                    progressBarSignup.visibility=View.GONE
                                }

                            }
                    }
                }

        }
    }
}