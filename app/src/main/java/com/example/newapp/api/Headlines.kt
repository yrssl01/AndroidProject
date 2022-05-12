package com.example.newapp.api

import com.example.newapp.model.NewResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HeadlinesApi {

    @GET("v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
    ): Response<NewResponse>
}