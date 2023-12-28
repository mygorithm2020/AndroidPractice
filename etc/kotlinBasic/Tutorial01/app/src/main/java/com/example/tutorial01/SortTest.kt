package com.example.tutorial01


fun main(){
    MutableListSort()

}

fun MutableListSort(){

    var qqq = mutableListOf<String>()
    qqq.add("ccccc")
    qqq.add("qqq")
    qqq.add("www")

    for (one in qqq){
        println(one)
    }

    qqq.sortWith(compareBy{it.length})

    for (one in qqq){
        println(one)
    }

    var www = mutableListOf<SortTest>()

    www.add(SortTest(1, "one"))
    www.add(SortTest(5, "five"))
    www.add(SortTest(2, "two"))
    www.add(SortTest(4, "four"))
    www.add(SortTest(3, "three"))

    for (one in www){
        println(one.id)
    }


    www.sortBy { it.name }

    for (one in www){
        println(one.id)
        println(one.name)
    }

}

class SortTest(
    var id: Int,
    var name: String
    ) {

}