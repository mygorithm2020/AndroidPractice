package com.example.tutorial01

import java.math.BigDecimal

fun main(){
    test01()

}

fun test01(){
    var aa = BigDecimal.ZERO
    var bb = null

//    var cc = aa.add(bb)
//    println(cc)
    var dd = aa.plus(bb!!)
    println(dd)
}

class Decimal {
}