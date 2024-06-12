package com.example.myapplicationeight.data

import com.example.myapplicationeight.domain.Item
import retrofit2.Response
import retrofit2.http.*

interface ItemApiInterface {

    @GET("habit")
    suspend fun getHabits():Response<List<Item>>

    @PUT("habit")
    suspend fun addHabit(@Body item: Item):Response<String>

    @PUT("habit")
    suspend fun updateHabit(@Body item: Item):Response<String>

}