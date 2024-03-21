package com.example.restaurantapp.models

data class LogResponse(
    val `data`: DataX,
    val result_code: Int,
    val result_msg: String
)