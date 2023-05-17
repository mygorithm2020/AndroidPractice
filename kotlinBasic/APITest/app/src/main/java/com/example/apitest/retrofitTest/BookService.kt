package com.example.apitest.retrofitTest

import com.example.apitest.model.BestSellerDto
import com.example.apitest.model.SearchBookDto
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    @GET("/api/search.api?output=json")
    fun getBookbyName(
        @Query("key") apiKey:String,
        @Query("query") keyWord:String
    ): Call<SearchBookDto>

    @GET("/api/bestSeller.api?output=json&categoryId=100")
    fun getBestSeller(
        @Query("key") apiKey:String
    ): Call<BestSellerDto>


}

