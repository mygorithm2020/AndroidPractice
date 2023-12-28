package com.example.diceroller02

class Inheritance {
}

fun main(){
    var dog :Dog = Yorkshire()
    dog.sayHello()
    dog = JindoDog()
    dog.sayHello()
}

// 상속 허용 open 디폴트는 fianl
open class Dog {
    open fun sayHello(){
        println("wow wow!")
    }
    constructor(){

    }

    final fun Died(){

    }
}

class Yorkshire : Dog(){
    override fun sayHello() {
        super.sayHello()
    }
}

class  JindoDog : Dog(){
    override fun sayHello() {
        println("wif wif")
    }
}