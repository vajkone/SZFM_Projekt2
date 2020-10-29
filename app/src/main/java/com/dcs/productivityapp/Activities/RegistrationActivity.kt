package com.dcs.productivityapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.dcs.productivityapp.Model.User
import com.dcs.productivityapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_signup.*




class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        mAuth=FirebaseAuth.getInstance()

        signUpBtn.setOnClickListener {

            val email=signUpEmail.text.toString()
            val password=signUpPassword.text.toString()
            val name=signUpName.text.toString()
            val age=signUpAge.text.toString()

            if(name.isEmpty()){
                signUpName.error = "Enter your name!"
                signUpName.requestFocus()
                return@setOnClickListener
            }

            if(age.isEmpty()){
                signUpAge.error = "Enter your age!"
                signUpAge.requestFocus()
                return@setOnClickListener
            }

            if(email.isEmpty()){
                signUpEmail.error = "Enter your Email!"
                signUpEmail.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                signUpEmail.error="Please provide valid email!"
                signUpEmail.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty()){
                signUpPassword.error = "Enter your password!"
                signUpPassword.requestFocus()
                return@setOnClickListener
            }

            if(password.length <6){
                signUpPassword.error = "Min password length should be 6 characters!"
                signUpPassword.requestFocus()
                return@setOnClickListener
            }

            progressBarSignup.visibility= View.VISIBLE
            mAuth!!.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        val user = User(name, email)
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