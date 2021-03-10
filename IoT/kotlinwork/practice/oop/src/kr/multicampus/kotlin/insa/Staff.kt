package kr.multicampus.kotlin.insa

class Staff {
    var name:String = ""
    var age:Int = 0
    var dept:String = ""

    constructor(name:String){
        this.name = name
    }
    constructor(name:String,age:Int):this(name){
        this.age = age
    }
    constructor(name:String,age:Int,dept:String):this(name,age){
        this.dept = dept
    }
    fun print(){
        println("이름:$name,나이:$age,교무과:$dept")
    }
}