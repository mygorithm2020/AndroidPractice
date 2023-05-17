package com.example.recyclerviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    lateinit var profileAdapter: ProfileAdapter
//    val datas = mutableListOf<ProfileData>()

    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter:RecyclerViewAdapter //adapter객체 먼저 선언해주기!

    val mDatas=mutableListOf<DogData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializelist()
        initDogRecyclerView()


    }

    fun initializelist(){ //임의로 데이터 넣어서 만들어봄
        with(mDatas){
            add(DogData("","dog1",20,"M"))
            add(DogData("","dog2",20,"M"))
            add(DogData("","dog3",20,"M"))
            add(DogData("","dog4",20,"M"))
            add(DogData("","dog5",20,"M"))
            add(DogData("","dog2",20,"M"))
            add(DogData("","dog6",20,"M"))
            add(DogData("","dog7",20,"M"))
            add(DogData("","dog8",20,"M"))
            add(DogData("","dog9",20,"M"))
            add(DogData("","dog10",20,"M"))
            add(DogData("","dog11",20,"M"))
            add(DogData("","dog12",20,"M"))
        }
    }

    fun initDogRecyclerView(){
        val adapter=RecyclerViewAdapter() //어댑터 객체 만듦
        binding.recyclerView.adapter=adapter //리사이클러뷰에 어댑터 연결
        adapter.datalist=mDatas //데이터 넣어줌
        binding.recyclerView.layoutManager= LinearLayoutManager(this) //레이아웃 매니저 연결
    }



//    private fun initRecycler() {
//        profileAdapter = ProfileAdapter(this)
//        rv_profile.adapter = profileAdapter
//
//
//        datas.apply {
//            add(ProfileData(img = R.drawable.profile1, name = "mary", age = 24))
//            add(ProfileData(img = R.drawable.profile3, name = "jenny", age = 26))
//            add(ProfileData(img = R.drawable.profile2, name = "jhon", age = 27))
//            add(ProfileData(img = R.drawable.profile5, name = "ruby", age = 21))
//            add(ProfileData(img = R.drawable.profile4, name = "yuna", age = 23))
//
//            profileAdapter.datas = datas
//            profileAdapter.notifyDataSetChanged()
//
//        }
//    }

}

data class DogData(
    val dog_img : String,
    val dog_name : String,
    val dog_age : Int,
    val dog_gender : String
)

data class ProfileData (
    val name : String,
    val age : Int,
    val img : Int
)