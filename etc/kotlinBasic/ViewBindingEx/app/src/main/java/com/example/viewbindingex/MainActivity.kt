package com.example.viewbindingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewbindingex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding : ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)

        binding.tvMessage.setText("안녕하세요 홍드로이드 입니다.")
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}