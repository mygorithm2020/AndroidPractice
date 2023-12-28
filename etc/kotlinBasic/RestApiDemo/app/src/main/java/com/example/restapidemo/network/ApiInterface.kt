package com.example.restapidemo.network

import com.example.restapidemo.home.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun fetchAllPosts(): Call<List<PostModel>>
}