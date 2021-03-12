package kr.multicampus.kotlin.basic

fun main(){
    /*
    * 제어구문
    * 1. if
    *   if, if~else, if~else if~else
    *
    * */

    val num1:Int = 97
    var result:String =""
    if(num1>=90){
        result = "합격"
    }else{
        result = "불합격"
    }
    println("result=$result")

    val result2:String = if(num1>=90)"합격" else "불합격"
    println("result2=$result2")

    val result3:String = if(num1>=90){
        println("조건이 만족할 때 실행할 명령문.......")
        "합격" //마지막 문장에서 리터럴의 형태로 값을 주면 이 마지막 문장의 값이 변수에 저장
    }else{
        println("조건이 만족하지 않을 때 실행할 명령문.......")
        "불합격"
    }
    println("result3=$result3")
}