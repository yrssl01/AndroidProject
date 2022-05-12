package com.example.newapp.injection

import com.example.newapp.api.HeadlinesApi
import com.example.newapp.model.NewResponse
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor(
    val HeadlinesApi: HeadlinesApi
) {

    suspend fun getTopHeadlines(country: String, apiKey: String): Response<NewResponse> {
        return HeadlinesApi.getHeadlines(country, apiKey)
    }

}