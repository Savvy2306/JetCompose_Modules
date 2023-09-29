package com.sarvesh.jetcompose_modules.Retrofit.network

import com.sarvesh.jetcompose_modules.Retrofit.PostDTO
import retrofit2.http.GET

interface ApiService {

    companion object{
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getPost():List<PostDTO>
}