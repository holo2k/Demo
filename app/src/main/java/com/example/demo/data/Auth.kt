package com.example.demo.data

data class auth(val token: Int)
{
    companion object login{
        var userToken:Int?=null
    }
}
