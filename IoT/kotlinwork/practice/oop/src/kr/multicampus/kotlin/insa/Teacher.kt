package kr.multicampus.kotlin.insa

class Teacher constructor(var name:String,var age:Int){
    var subject:String=""
    constructor(name:String, age:Int, subject:String):this(name,age){
        this.subject = subject
    }
    fun print(){
        println("이름:$name,나이:$age,담당과목:$subject")
    }
}