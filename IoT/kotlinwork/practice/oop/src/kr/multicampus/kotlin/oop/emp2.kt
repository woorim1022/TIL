package kr.multicampus.kotlin.oop

//선언된 패키지 안에 클래스를 정의한다.
class Emp {
    var name:String = ""
    var addr:String = ""
    var age:Int = 0

    constructor(name:String){
        this.name = name
        println("매개변수1개생성자")
    }
    constructor(name:String,addr:String):this(name){
        this.addr = addr
        println("매개변수2개생성자")
    }
    constructor(name:String,addr:String,age: Int):this(name,addr){
        this.age = age
        println("매개변3개생성자")
    }

}