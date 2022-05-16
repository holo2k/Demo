package com.example.demo

import com.example.demo.net.ApiRet
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Obj {
    fun getRetrofit(): ApiRet {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://food.madskill.ru")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val getApi = retrofit.create(ApiRet::class.java)
        return getApi
    }
}