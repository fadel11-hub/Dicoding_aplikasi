package com.example.dicodingaplikasi.data.retrofit

import com.example.dicodingaplikasi.data.response.EventResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("detail/{id}")
    fun getUpComing(
        @Path("id") id: Int
    ): Call<EventResponse>

}