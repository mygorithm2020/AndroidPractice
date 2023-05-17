package com.example.databindingex02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import com.example.databindingex02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var text = "TEST"
    var objTest = BindingTest()

    val liveText = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        objTest.id = 0
//        objTest.name = "HI!!"
//        binding.activity = this
//        binding.btnChange.setOnClickListener{
//            text = "TEST22"
//            objTest.id ++
//            objTest.name = objTest.name + objTest.id
//            binding.invalidateAll()
//        }

        binding.apply {
            lifecycleOwner = this@MainActivity
            activity = this@MainActivity

            btnChange.setOnClickListener{
                if (liveText.value == "Hello LiveData!"){
                    liveText.value = "Hello LiveData!!!!!"
                }else{
                    liveText.value = "Hello LiveData!"
                }

            }
        }
    }
}

class BindingTest(){
    var id :Int = 0
    var name : String = ""
}