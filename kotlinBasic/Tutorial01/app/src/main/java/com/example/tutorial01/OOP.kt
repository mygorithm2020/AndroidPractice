package com.example.tutorial01

fun main() {
    InitObj()
}

fun InitObj() {
    val c1 = Car()
    c1.brand = "Ford"
    c1.model = "Mustang"
    c1.year = 1969
    c1.drive()

    println(c1.brand)
    println(c1.model)
    println(c1.year)

    val h1 = House("HDC", "Seoul", 3000)

    val c2 = Cars("Volvo", "S60", 2022)
    c2.drive()
    c2.speed(250)
}

class Car {
    var brand = ""
    var model = ""
    var year = 0

    fun drive() {
        println("Wroom!")
    }
}

class House(var brand: String, var location: String, var price: Int)


class Cars(var brand: String, var model: String, var year: Int) {
    fun drive() {
        println("부르르르르릉!")
    }

    fun speed(maxSpeed: Int) {
        println("Max speed is : " + maxSpeed)
    }

    override fun toString(): String {
        return "Cars(brand='$brand', model='$model', year=$year)"
    }


}

class OOP {
}

