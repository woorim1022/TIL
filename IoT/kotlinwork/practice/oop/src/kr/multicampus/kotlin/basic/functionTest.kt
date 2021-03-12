package kr.multicampus.kotlin.basic

fun main() {
    /*
    * 1) 코틀린에서 함수를 정의한 자바로 변환될 때 클래스의 메소드로 변환
    * 2) 함수 - 자바스크립트, c언어와 동일한 방법 동일한 개념으로 선언하고 사용할 수 있다.
    *       fun 함수명(매개변수):반환값의 타입{
    *               함수 내부에서 처리할 명령문
    *               [return]
    *       }
    * 3) 반환값의 타입은 지원하는 데이터타입, 반환값이 없는 경우 (Unit - void 와 동일)
    *   Unit은 생략 가능
    * 4) 함수를 호출할 때 변수명에 값을 할당할 수 있기 때문에 순서는 달라도 상관없다
    * 5) 함수를 정의할 때 매개변수에 초기값을 지정할 수 있다.
    * */
    test()
    test2()
    //intelliJ의 편리한 기능 - 어떤 변수에 값이 할당되는지 표시하는 기능(변수인 경우에는 표시되지 않는다.)
    val num1:Int = 10
    val num2:Int = 20
    add(100,200)
    add(num1, num2)
    add(num1=500, num2=1000)
    // 명시하지 않은 매개변수에는 초기값이 들어감
    add2(num1=10000)
    add2(num2=10000)
    val result1:Int = add3(100,200)
    val result2:Int = add3(1000,2000)
    println("result1=$result1")
    println("result2=$result2")

}


//리턴값이 없는 함수
fun test(){
    println("test함수")
    println("*******************")
}

fun test2():Unit{
    println("test2함수")
    println("*******************")
}

//매개변수가 있는 함수
fun add(num1:Int, num2:Int){
    println("num1=$num1")
    println("num2=$num2")
    println("*******************")
}

// 함수를 정의할 때 매개변수에 초기값을 지정할 수 있다.
fun add2(num1:Int=10, num2:Int=20){
    println("num1=$num1")
    println("num2=$num2")
    println("*******************")
}

//리턴값이 있는 함수
fun add3(num1:Int=10, num2:Int=20):Int{
    val result = num1 + num2 //데이터타입을 선언하지 않으면 할당된 값을 기준으로 데이터타입이 결정된다,
    return result
}