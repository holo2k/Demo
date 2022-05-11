package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class login : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun isValidEmail(email:String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun mainActivity(view: android.view.View) {
        email = findViewById(R.id.editTextEmail)
        pass = findViewById(R.id.editTextPassword)
        if(email.text.isNotEmpty() && pass.text.isNotEmpty()){
            if(isValidEmail(email.text.toString())) {
                AlertDialog.Builder(this)
                    .setTitle("Succeed")
                    .setMessage("You succesfully logged in")
                    .setPositiveButton("OK", null)
                    .create()
                    .show()
            }
            else
            {
                AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage("Email is not correct")
                    .setPositiveButton("OK", null)
                    .create()
                    .show()
            }
        }

        else
        {
           AlertDialog.Builder(this)
               .setTitle("Error")
               .setMessage("Login or password is empty")
               .setPositiveButton("OK",null)
               .create()
               .show()
        }
    }
}