package com.example.mvvmrecap.api

import com.example.mvvmrecap.data.Restaurant
import retrofit2.Response
import retrofit2.http.GET

interface RestaurantApi {



    companion object{
        const val BASE_URL = "https://random-data-api.com/api/"

    }

    @GET("restaurant/random_restaurant?size=20")
    suspend fun getRestaurants(): List<Restaurant>
}