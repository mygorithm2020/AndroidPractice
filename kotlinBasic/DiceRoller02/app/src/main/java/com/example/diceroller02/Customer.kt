package com.example.diceroller02

fun main(){
    val basic = Basic()
    var contact = Contact(1, "mary@gmail.com")
    println(contact.id)
    contact.email = "fix@gmail.com"
    contact = Contact(2, "qqqq")
}
class Customer {

}


class Basic

class Contact(val id:Int, var email: String?)

