package com.example.databindingex

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.databindingex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var text = "Test"
    //var qwer = bindingClass()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)



        binding.activity = this
        binding.btnChange.setOnClickListener{
            text = "Test22"
            binding.invalidateAll()
//            qwer.id++
//            if (qwer.name == ""){
//                qwer.name = "HI  "
//            }else{
//                qwer.name = qwer.name + qwer.id
//            }


        }
    }
}