package com.example.apitest.retrofitTest

import android.util.Log
import com.example.apitest.model.BestSellerDto
import com.example.apitest.model.Book
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun main(){
    var qq = Book(1, "!", "2", "2")

    val retrofit = Retrofit.Builder().baseUrl("https://book.interpark.com").addConverterFactory(GsonConverterFactory.create()).build()
    val bookService = retrofit.create(BookService::class.java)
    bookService.getBestSeller("38845BE9BD0EBEDF271A2D5BC770C5BEEBB2D38910F504545CE384C6692DA6D4")
        .enqueue(object: Callback<BestSellerDto>{
            override fun onFailure(call: Call<BestSellerDto>, t: Throwable) {
                println(t.toString())
                Log.d("Tag", t.toString())
            }

            override fun onResponse(call: Call<BestSellerDto>, response: Response<BestSellerDto>) {
                if(response.isSuccessful.not()){
                    return
                }
                response.body()?.let {
                    //Log.d("TAG", it.toString())
                    println(it.toString())
                    it.books.forEach { book ->
                        println(book.toString())
                        //Log.d("TAG", book.toString())
                    }
                }

                println("The End")
            }
        })

}



class RetrofitTest {
}