package com.example.tutorial01

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

class Datetime {
    fun test01(){
        println("test01")
        val cal = Calendar.getInstance()
        var playDate = "20230603"
        println(playDate.substring(0,4).toInt())
        println(playDate.substring(4,6).toInt())
        println(playDate.substring(6,8).toInt())
        cal.set(playDate.substring(0,4).toInt(), (playDate.substring(4,6).toInt()-1),playDate.substring(6,8).toInt())

        for (i: Int in 0..31){
            println(cal.get(Calendar.YEAR).toString() + cal.get(Calendar.MONTH).toString() + cal.get(Calendar.DATE).toString())
            println(cal.get(Calendar.DAY_OF_WEEK))
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                println("주말인디요???")
            }
            cal.add(Calendar.DATE, 1)
        }


    }
}
fun main(){
    val obj = Datetime()
    obj.test01()
}

