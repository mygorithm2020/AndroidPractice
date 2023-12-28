package com.example.tutorial01

class Inheritance {
}

fun main() {
    var obj = Child()
    obj.First()

    val myObj = MyChildClass()
    myObj.myFunction()
}

open class MyParentClass {
    val x = 5
}

class MyChildClass : MyParentClass() {
    fun myFunction() {
        println(x)
    }
}

open class Parent {

    open fun First() {
        println("Parent First")
        Second()
    }

    open fun Second() {
        println("Parent Second")
    }
}

class Child : Parent() {
    override fun First() {
        println("Child First")
        super.First()
    }

    override fun Second() {
        println("Child Second")
    }

}

