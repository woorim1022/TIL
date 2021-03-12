package kr.multicampus.kotlin.basic/*
* 여러가지 함수를 정의하고 테스트하기
* 1.kr.multicampus.kotlin.basic.display
*   [조건]
*   1) 입력받은 문자를 평가하는 함수
*       매개변수 : char
*       리턴값 : String
*   2) 실행
*       0~9까지 입력하면 : 숫자입니다.
*       a~z, A~Z : 문자입니다
*       그 외 : 판단할 수 없습니다.
*   3) Scanner 이용하지 않고 그냥 테스트하기
*   4) 함수의 리턴값은 when 블럭을 이용해서 구하기
* 
* 
* 2.kr.multicampus.kotlin.basic.printdata => kr.multicampus.kotlin.basic.printdata(1..10)
*   0) 전달 받은 숫자범위의 값들 중 조건에 만족하는 데이터 출력하기
*   1) 매개변수 : ...연산자로 구성된 범위의 숫자들
*      리턴값 없음
*   2) 3의 배수인 숫자만 출력하기
*   3) main에서 함수를 호출할 때 범위에 해당하는 두 숫자는 scanner로 입력처리
* 
* 
* 3.kr.multicampus.kotlin.basic.printSumArray
*   - 매개변수로 전달받은 배열 요소들의 합과 평균 출력
*   - 매개변수 Int 배열
*   - kr.multicampus.kotlin.basic.main 함수에서 printSumArray를 호출하여 매개변수로 전달
* */


import java.util.Scanner

fun main(){
    val key:Scanner = Scanner(System.`in`)

    //1. kr.multicampus.kotlin.basic.display
    println("1. kr.multicampus.kotlin.basic.display")
    print("문자를 입력하세요 : ")
    var c:Char = key.next().toCharArray()[0]
    var result = display(c)
    println("kr.multicampus.kotlin.basic.display('$c') ===> $result")
    println("********************************************")

    //2. kr.multicampus.kotlin.basic.printdata
    println("2. kr.multicampus.kotlin.basic.printdata")
    print("숫자 1 : ")
    val num1:Int = key.nextInt()
    print("숫자 2 :")
    val num2:Int = key.nextInt()
    printdata(num1..num2)
    println("********************************************")

    //3. kr.multicampus.kotlin.basic.printSumArray
    println("3. kr.multicampus.kotlin.basic.printSumArray")
    val myarr = arrayOf(10,20,30,40,50)
    printSumArray(myarr)
    println("********************************************")
}

fun display(c:Char):String = when(c){
    in '0'..'9' -> "숫자입니다"
    in 'a'..'z' -> "문자입니다"
    in 'A'..'Z' -> "문자입니다"
    else -> "판단할 수 없습니다"
}

fun printdata(numrange:IntRange){
    for(item in numrange){ // i는 임의로 선언하는 변수
        if (item%3 == 0)
            println("$item")
    }
}

fun printSumArray(myarr:Array<Int>){
    var sum:Int = 0
    for(item in myarr){
        sum += item
    }
    println("합 : $sum")
    println("평균 : ${sum/5}")
}
