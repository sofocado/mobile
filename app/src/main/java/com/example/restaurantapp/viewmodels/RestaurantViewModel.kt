package com.example.restaurantapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.restaurantapp.api.ClientApi
import com.example.restaurantapp.models.LogResponse
import com.example.restaurantapp.models.LoginRequest
import com.example.restaurantapp.models.Row
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantViewModel : ViewModel() {
    private val retrofitBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://172.20.10.3:1001/")
        .build()
        .create(ClientApi::class.java)

    private val _restaurantData = MutableLiveData<List<Row>>()
    val restaurantData: LiveData<List<Row>> = _restaurantData

    private val _loginStatus = MutableLiveData<Boolean>()
    val loginStatus: LiveData<Boolean> = _loginStatus


    private var userData: JsonObject? = null
    val userDataLiveData: LiveData<JsonObject>
        get() = MutableLiveData<JsonObject>().apply {
            value = userData
        }
    // Observe userDataLiveData in your fragment






    fun login( phoneNumber: String, password: String) {
        val loginRequest = LoginRequest(
            phoneNumber = phoneNumber,
            password = password
        )
        retrofitBuilder.login(loginRequest).enqueue(object : Callback<LogResponse?> {



            override fun onResponse(call: Call<LogResponse?>, response: Response<LogResponse?>) {
                if (response.isSuccessful) {
                    val logResponse = response.body()
                    if (loginResponse != null && loginResponse.resultCode == 0 && loginResponse.resultMsg == "Success!") {
                        val accessToken = loginResponse.data.accessToken
                        val refreshToken = loginResponse.data.refreshToken
                        val user = loginResponse.data.user
                        val userId = user._id
                        val userName = user.name
                        val userPhoneNumber = user.phoneNumber

                        // Now you can use accessToken, refreshToken, userId, userName, userPhoneNumber, etc.
                    } else {
                        // Handle unsuccessful login response
                        val errorMsg = loginResponse?.resultMsg ?: "Unknown error"
                        Log.d("RestaurantModel", "Login failed: $errorMsg")
                    }

                } else {
                    // Handle unsuccessful response
                    Log.d("RestaurantViewModel", "Failed to login: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<LogResponse?>, t: Throwable) {
                // Handle failure
                Log.d("RestaurantViewModel", "Failed to login: ${t.message}")
            }
        })
    }

    fun fetchData() {
        retrofitBuilder.getData().enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    val rowsJsonArray = responseBody?.getAsJsonArray("data")

                    if (rowsJsonArray != null) {
                        val rows = mutableListOf<Row>()
                        rowsJsonArray.forEach { jsonElement ->
                            val row = Gson().fromJson(jsonElement, Row::class.java)
                            rows.add(row)
                        }
                        _restaurantData.value = rows
                    } else {
                        Log.d("HomeViewModel", "Failed to parse rows from response")
                    }
                } else {
                    Log.d("HomeViewModel", "Failed to fetch data: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                // Handle failure
                Log.d("HomeViewModel", "Failed to fetch data: ${t.message}")
            }
        })
    }

}
