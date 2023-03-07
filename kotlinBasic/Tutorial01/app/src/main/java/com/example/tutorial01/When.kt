package com.example.tutorial01


class When {

}

fun main(){
    WhenTest()
    println("===============================================")
    WhileTest()
    println("===============================================")
    DoWhileTset()
    println("===============================================")
    BreakTest()
    println("===============================================")
    ContinueTest()
    println("===============================================")
}

fun WhenTest(){
    val day = 4

    //val result =
    var result = when(day){
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        6 -> "Saturday"
        7 -> "Sunday"
        else -> "Invalid day."
    }
    println(result)
}

fun  WhileTest(){
    var i = 0
    while (i<5){
        println(i)
        i++
    }
}

fun DoWhileTset(){
    var i = 10
    do{
        println(i)
        i++
    }while (i < 5)
}

fun BreakTest(){
    var i = 0
    while (i < 10){
        println(i)
        i++
        if (i == 4){
            println("break")
            break
        }
    }
}

fun ContinueTest(){
    var i = 0
    while (i < 10){
        if (i == 4){
            i++
            continue
        }
        println(i)
        i++
    }
}