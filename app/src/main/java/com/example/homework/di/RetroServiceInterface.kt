package com.example.homework.di

import com.example.homework.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetroServiceInterface {

    @GET("{list}")
    fun getDataFromAPI( @Path("list") list: String): Call<RecyclerList>?

}