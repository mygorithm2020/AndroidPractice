package com.example.myapplication

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface API {
    @Headers("Content-Type: application/json")
    @POST("/api/Shop/GetPaymentList")
    fun getPaymentList(@Body params: TeetimeRequestData): Call<ApiResult>
}