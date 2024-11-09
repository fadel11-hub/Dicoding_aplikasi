package com.example.dicodingaplikasi.data.retrofit

import com.example.dicodingaplikasi.data.response.DetailResponse
import com.example.dicodingaplikasi.data.response.EventResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("events")
    fun getUpComing(
        @Query("active") active: Int
    ): Call<EventResponse>

    @GET("events/{id}")
    fun getDetailEvent(
        @Path("id") id: String
    ): Call<DetailResponse>

}