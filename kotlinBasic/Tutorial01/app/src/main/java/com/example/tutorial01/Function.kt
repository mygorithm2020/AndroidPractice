package com.example.tutorial01


fun main(){
    println("hello World")
    myFunction("????!!!!", 12)
    var result  = myFunction(10)
    println(result)
    result  = myFunction(10, 5)
    println(result)
}

fun myFunction(fname : String){
    println(fname + "Doe")
}

fun  myFunction(fname: String, age : Int){
    println(fname + "is" + age)
}

fun myFunction(x:Int) : Int{
    return  x + 5
}

fun myFunction(x:Int, y: Int)  = x + y

class Function {
}