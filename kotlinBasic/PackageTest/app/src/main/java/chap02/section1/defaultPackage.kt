package chap02.section1

import com.example.packagetest.Person as User
import kotlin.math.PI
import kotlin.math.abs

class defaultPackage {
}

fun main(){
    val intro : String = "안녕하세요!"
    val num = 20

    println(PI)
    println(abs(-12.6))

    println("intro: $intro, num: $num")

    val user1 = User()
}