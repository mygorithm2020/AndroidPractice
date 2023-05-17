package com.example.tutorial01

import android.os.Build
import android.support.annotation.RequiresApi
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class Tutorial01 {
}

@RequiresApi(Build.VERSION_CODES.O)
fun main(){
//    Test01()
//    println("----------------------------------------")
//    Test02()
//    println("----------------------------------------")
//    Test03()
//    println("Test05----------------------------------------")
//    Test05()
    Test06()
}

fun Test06(){
    for (i : Int in 1..5){
        println(i)
    }
}



@RequiresApi(Build.VERSION_CODES.O)
fun Test05(){
    var playDate = "20230314"
    var startTime = "1234"

    var qqq = LocalDate.parse(playDate+startTime, DateTimeFormatter.ofPattern("yyyyMMddHHmm"))
    println(qqq)
    println(qqq::class.simpleName)

    var www = LocalDateTime.parse(playDate+startTime, DateTimeFormatter.ofPattern("yyyyMMddHHmm"))
    println(www)
    println(www::class.simpleName)

//    val utcToday = LocalDateTime.now(ZoneOffset.UTC)
//    var today = utcToday.plusHours(9)
//    println(utcToday)
//    println(utcToday.toString())
//    println(today)
//
//    val paymentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmm"))
//    println(paymentTime)
//
//    val utcToday02 = LocalDate.now(ZoneOffset.UTC)
//    var today02 = utcToday02
//    println(utcToday02)
//    println(today02)
//
//    println(System.currentTimeMillis())
}

fun Test04(){
    var str : String = "aaaa"
    str.trim { it <= ' ' }
}

fun Test03(){
    var str : String = ""
    println(str.take(4))
    println(str.takeLast(5))
    if (str.take(4) == "null"){
        println("qqqq")
    }
}

private  fun Test02(){
    var txt1 = "It 's alright"
    println(txt1)
    println("hi, $txt1")

    var cc = 10
    println(cc)
    println(cc::class.simpleName)
    var dd : Any? = cc
    println(dd)
    println(dd!!::class.simpleName)
    println(dd.toString().toInt())
    println(dd.toString().toInt()::class.simpleName)
    var ee : Any? = 10
    println(ee)
    println(ee!!::class.simpleName)

    var qq = 1.0
    println(qq)
    println(qq::class.simpleName)
    var ww : Any? = qq
    println(ww)
    println(ww!!::class.simpleName)
//    var ss = ww.toString().toInt()
//    println(ss)
//    println(ss::class.simpleName)
    var xx : Int = ww.toString().toDouble().toInt()
    println(xx)
    println(xx::class.simpleName)

}

private fun Test01(){
    print("hi")
    print("my")
    print("name")
    print("is")
    var aa = "String"
    val bb : String
    bb = "111"
    val cc : Int = 4321
    val dd = 999
    println(aa+bb + cc)
    println(cc+dd)

    var number  = 5
    var llllong = number.toLong()
    number++
    number += 5
    println(number)
    println(5/4)

    var aa02 = "String"
    var bb02 = aa02
    bb02 = "Int"
    println(bb02)
    println(aa02)

    var qq : String?
    qq = null
    //qq.toUpperCase()

    var www :BigDecimal  = BigDecimal.valueOf(111)
    println(www)

    var str01 = "Hello"
    var str02 = "Hello"
    if (str01 == str02){
        println("same")
    }
    println(str01.compareTo(str02))
    str02 = "hello"
    println(str01.compareTo(str02))
    str02 = "Iello"
    println(str01.compareTo(str02))
}