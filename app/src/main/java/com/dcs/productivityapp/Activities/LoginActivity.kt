package com.dcs.productivityapp.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.dcs.productivityapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


var mAuth: FirebaseAuth? =null

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth=FirebaseAuth.getInstance()
        progressBarLogin.visibility= View.INVISIBLE

        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            // User is signed in
            val i = Intent(this, MainActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(i)
        } else {
            // User is signed out
        }




        signUp.setOnClickListener {
            var intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener {
            userLogin()
        }
    }

    private fun userLogin() {
        val email = loginEmail.text.toString()
        val pass=loginPassword.text.toString()

        if (email.isEmpty()){
            loginEmail.error = "Email is required"
            loginEmail.requestFocus()
            return
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            loginEmail.error = "Please enter a valid email"
            loginEmail.requestFocus()
            return
        }

        if (pass.isEmpty()){
            loginPassword.error="Enter your password"
            loginPassword.requestFocus()
            return
        }

        progressBarLogin.visibility= View.VISIBLE

        mAuth!!.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            if (it.isSuccessful){
                val intent=Intent(this,MainActivity::class.java)
                progressBarLogin.visibility=View.GONE
                startActivity(intent)
            }else{
                Toast.makeText(this,"Failed to login, please check your credentials",Toast.LENGTH_LONG).show()
                progressBarLogin.visibility=View.GONE
            }
        }
    }
}