package com.dcs.productivityapp.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dcs.productivityapp.R
import kotlinx.android.synthetic.main.activity_contact.*

class Contact: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        setSupportActionBar(toolBar)
        title = "Contact Us"
    }
}