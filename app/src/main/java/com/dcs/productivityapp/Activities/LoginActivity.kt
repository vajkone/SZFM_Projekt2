package com.dcs.productivityapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dcs.productivityapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        signUp.setOnClickListener {
            var intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}