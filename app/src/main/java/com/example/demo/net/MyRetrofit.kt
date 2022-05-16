package com.example.demo.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyRetrofit {
    fun getRetrofit() :Retrofit = Retrofit.Builder()
        .baseUrl("https://food.madskill.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}