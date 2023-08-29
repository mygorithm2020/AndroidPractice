package com.example.restapidemo.home.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.restapidemo.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var apiInterface : ApiInterface? = null
class HomeRepository {
    fun fetchAllPosts(): LiveData<List<PostModel>>{
        val data = MutableLiveData<List<PostModel>>()

        apiInterface?.fetchAllPosts()?.enqueue(object : Callback<List<PostModel>> {
            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                data.value = null
            }

            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {

                val res = response.body()
                if (response.code() == 200 &&  res!=null){
                    data.value = res
                }else{
                    data.value = null
                }
            }
        })

        return data
    }
}

