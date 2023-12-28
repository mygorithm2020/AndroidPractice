package com.example.classtest

fun main(){
    var qq = FirstClass()
    qq.name = "qqq"
    println(qq.name)

}

class FirstClass {
    lateinit var name: String
}