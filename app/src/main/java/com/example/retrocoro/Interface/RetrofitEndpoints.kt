package com.example.retrocoro.Interface

import com.example.retrocoro.Classes.primary
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitEndpoints{
    @GET("quotes")
    suspend fun getQuotes() : Response<primary>
}