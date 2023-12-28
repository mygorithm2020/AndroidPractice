package com.example.restapidemo.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.restapidemo.home.model.HomeRepository
import com.example.restapidemo.home.model.PostModel

class HomeViewModel {
    private var homeRepository: HomeRepository? = null
    var postModelListLiveData : LiveData<List<PostModel>>? = null

    init {
        homeRepository = HomeRepository()
        postModelListLiveData = MutableLiveData()
    }

    fun fetchAllPosts(){
        postModelListLiveData = homeRepository?.fetchAllPosts()
    }
}