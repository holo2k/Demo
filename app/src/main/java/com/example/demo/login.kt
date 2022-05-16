package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.demo.data.auth
import retrofit2.Call
import retrofit2.Response

class login : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var pass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun isValidEmail(email:String):Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun mainActivity(view: android.view.View) {
        email = findViewById(R.id.editTextEmail)
        pass = findViewById(R.id.editTextPassword)
        if(email.text.isNotEmpty() && pass.text.isNotEmpty()){
            if(isValidEmail(email.text.toString())) {
                val getApi = Obj.getRetrofit()
                var hashMap:HashMap<String,String> = HashMap<String,String>()
                hashMap.put("email",email.text.toString())
                hashMap.put("password", pass.text.toString())
                val log_call: retrofit2.Call<auth> = getApi.getAuth(hashMap)
                log_call.enqueue(object:retrofit2.Callback<auth>{
                    override fun onResponse(call: Call<auth>, response: Response<auth>) {
                        if(response.isSuccessful)
                        {
                           //val editor =  sharedPreferences.edit()
                           //editor.putString("id",response.body()?.id)
                           //editor.putString("avatar",response.body()?.avatar)
                           //editor.putString("Name",response.body()?.nickName)
                           //editor.apply()
                            val menu = Intent(this@login, menuActivity::class.java)
                            startActivity(menu)
                        }
                        else {
                            Toast.makeText(this@login, "Неверный пароль", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<auth>, t: Throwable) {
                        Toast.makeText(this@login,t.message,Toast.LENGTH_LONG).show()
                    }
                })
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