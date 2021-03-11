package kr.multicampus.kotlin.oop

fun main(){
    val obj1:SubClass = SubClass()
    println("obj1객체로 부모클래스의 멤버면수 접근:${obj1.superVal}")
    obj1.display()

    val obj2:SubClass2 = SubClass2(10,11111111)
    println("obj2객체로 부모클래스의 멤버면수 접근:${obj2.superVal}")
    println("obj2의 멤버면수:${obj2.age},${obj2.telNum}")
    obj2.display()
}


// class를 저의하면 코틀린이 컴파일 될 때 자바코드로 변환되면서 public final이 추가
// class SuperClass ---> public final class SuperClass {}
// open class SuperClass ---> public class SuperClass {}
/*
* final의 의미
* 변수 : 상수
* 메소드 : 재정의 할 수 없는 메소드
* 클래스 : 상속할 수 없는 클래스(마지막 자식)
* */

// 상위클래스는 open을 이용해서 상속이 가능한 클래스로 만들어야 한다.
open class SuperClass{
    var superVal = 100
    fun display(){
        println("부모클래스의 display")
    }
}

// 클래스를 상속받는 경우 반드시 상위클래스의 생성자를 호출해야 한다.
// 상위클래스의 주 생성자를 주로 호출한다.
// 상위클래스에 생성자가 정의되어 있지 않으면 매개변수가 없는 생성자를 호출한다.
class SubClass:SuperClass(){

}
class SubClass2:SuperClass{
    var age:Int
    var telNum:Int
    constructor(age:Int, telNum:Int):super(){ //SubClass2의 객체가 생성되면 부모의 매개변수 없는 생성자를 먼저 호출한다.
        this.age = age
        this.telNum = telNum
    }
}