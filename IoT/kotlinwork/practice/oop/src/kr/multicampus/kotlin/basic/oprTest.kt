package kr.multicampus.kotlin.basic

fun main(){
    /*
    * 연산자
    *   - 연산자와 동일한 함수를 제공한다.
    *   1. 단항연산잔자
    *       ++, --, +, -, !
    *       1) +
    *           양수->양수, 음수->음수
    *       2) -
    *           양수->음수, 음수->양수
    *       3) !
    *           true->false, false->true
    *   2. 산술연산자
    *       a+b, a-b, a*b, a/b, a%b
    *       a..b => a와 b사이 값
    *   3. 대입연산자
    *       +=, -=, *= ...
    *   4. 비교연산자
    *       ==, !=, >, <, >=, <=
    * */

    val num1:Int = 100
    val num2:Int = -100

    val result1 = +num1
    val result2 = +num2

    println("num1=$result1")
    println("num2=$result2")
    println("***********************************")

    val num3:Int = 100
    val num4:Int = -100

    val result3 = -num3
    val result4 = -num4

    println("num3=$result3")
    println("num4=$result4")
    println("***********************************")


    //2. 산술연산자 - a..b : a와 b 사이값 - IntRange타입으로 선언
    val myvalues:IntRange = 10..20 // 10, 11, 12,.....20
    println("myvalues:$myvalues")
}