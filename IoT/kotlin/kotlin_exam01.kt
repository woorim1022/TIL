/*
*  계산기
* 1. 더하기
* 2. 빼기
* 3. 곱하기
* 4. 나누기
*
* 입력
* 원하는 작업을 선택하세요:________
* 숫자1:____
* 숫자2:____
* 연산결과:____
* ex)1
*  더하기 결과가 출력
*
* [조건]
* 1~4번까지 : calc함수로 작성
*       - 매개변수로 숫자1, 숫자2, 연산자(Int)
*       - 결과를 리턴받기
*       - when을 이용해서 처리리
 */


import java.util.Scanner

fun main(){
    val key:Scanner = Scanner(System.`in`)
    println("계산기")
    println("1. 더하기")
    println("2. 빼기")
    println("3. 곱하기")
    println("4. 나누기")
    print("원하는 작업을 선택하세요 : ")
    val opr:Int = key.nextInt()
    print("숫자1:")
    val num1:Int = key.nextInt()
    print("숫자2:")
    val num2:Int = key.nextInt()

    val result = calc(num1, num2, opr)

    if(result==99999) {
        println("잘못입력")
    }else{
        println("연산결과:$result")
    }

}


fun calc(num1:Int, num2:Int, opr:Int):Int{
    var result:Int
    when(opr){
        1 -> result = num1 + num2
        2 -> result = num1 - num2
        3 -> result = num1 * num2
        4 -> {
            if (num2 != 0)
                result = num1 / num2
            else
                result = 99999
        }
        else -> result = 99999
    }
    return result
}