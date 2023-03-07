package com.example.diceroller

fun  main(){
    println("ohhhohoho")
}

class test {
    fun main(){
        println("Hello, World!")
    }

    fun printMessage(message: String) : Unit{

    }

    fun sum(x:Int, y: Int): Int{
        return x+y
    }

    fun sum02(x:Int, y: Int) = x + y

    fun Test(){
        var a : String = "initial"
        println(a)
        val  b : Int = 1
        val c = 3

        var e: Int

        var neverNull: String = "This can't be null"
        //neverNull = null

        var nullable : String? = "You can keep a null here"
        nullable = null

        var inferredNonNull = "The compiler assumes non-null"
        //inferredNonNull = null

    }

    fun strLength(notNull: String): Int{
        return  notNull.length
    }


}