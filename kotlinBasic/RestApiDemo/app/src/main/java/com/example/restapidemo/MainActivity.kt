package com.example.restapidemo

import android.arch.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restapidemo.home.view.HomeAdapter
import com.example.restapidemo.home.viewModel.HomeViewModel

var vm
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutInflater

        val qq = ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private fun initAdapter() {
        adapter = HomeAdapter(this)
        rv_home.layoutManager = LinearLayoutManager(this)
        rv_home.adapter = adapter
    }
}