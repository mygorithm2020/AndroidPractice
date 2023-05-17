package com.example.tutorial01

class Arrays {
}

fun main(){
    ArrayTest()
    println("-------------------------------------")
    Example()
    println("-------------------------------------")
    LoopTest()
    println("-------------------------------------")
    RangeTest()
}

fun  LoopTest(){
    val cars = arrayOf("Volvo", "BMW", "Ford", "Mazda")
    for (x in cars) {
        println(x)
    }
}

fun  RangeTest(){
    for (chars in 'a'..'x'){
        println(chars)
    }

    for (nums in 5..15){
        println(nums)
    }
}


fun ArrayTest(){
    val cars = arrayOf("Volvo", 1, "BMW", "Ford", "Mazda")
    println(cars[0])
    println(cars[1])
    cars[1] = "Change"
    println(cars[1])
    cars[2] = "Hyundai"
    println(cars[2])
    println(cars[3])
    println(cars[0]::class.simpleName)
    println(cars[1]::class.simpleName)
    println(cars[2]::class.simpleName)
    println(cars[3]::class.simpleName)
    println(cars::class.simpleName)
    var test : IntArray

}

fun  Example(){
    val a = arrayOf(1,2,3)

    a.forEach {
        println(it)
    }

    val names = listOf("stud1", "stud2", "stud3")

    println("The List contains: ")
    names.forEach {
        println(it)
    }

    for (x in names){
        println(x)
    }

    var days:MutableList<String> = mutableListOf(
        "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday", "Sunday"
    )

    println("Given Mutable List contains:")
    days.forEach{
        print(it)
    }

    println("Mutable List after modification:")
    days.forEach{
        print(it + ", ")
    }
}