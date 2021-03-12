package kr.multicampus.kotlin.oop.ploy

class SNSSender(name:String ,var length:Int):Sender(name){
    override fun send(){
        println("$name 에게 SNS 전송하기")
    }
}
