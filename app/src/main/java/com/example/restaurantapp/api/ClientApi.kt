package com.example.restaurantapp.api

import com.example.restaurantapp.models.LogResponse
import com.example.restaurantapp.models.LoginRequest
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ClientApi {
    @GET("restaurant/list")
    fun getData() : Call<JsonObject>
    @POST("auth/login")
    fun login(@Body loginRequest: LoginRequest): Call<LogResponse>

}