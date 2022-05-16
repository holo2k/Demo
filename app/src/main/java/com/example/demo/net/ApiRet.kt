package com.example.demo.net

//import com.example.demo.feelings
//import com.example.demo.login
import com.example.demo.data.auth
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiRet {
    @POST("/auth/login")
    fun getAuth(@Body hashMap: HashMap<String,String>):Call<auth>

   // @GET("feelings")
    //fun getFeel():Call<feelings>
}