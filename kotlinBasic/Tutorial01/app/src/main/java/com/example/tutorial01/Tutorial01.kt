package com.example.tutorial01

import java.math.BigDecimal

class Tutorial01 {
}

fun main(){
    Test01()
    println("----------------------------------------")
    Test02()

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