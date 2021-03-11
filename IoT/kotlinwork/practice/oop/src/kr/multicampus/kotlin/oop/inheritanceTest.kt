package kr.multicampus.kotlin.oop

fun main(){
    val car1:Bus = Bus()
    car1.달린다()

    val car2:Truck = Truck()
    car2.달린다()

    val car3:Taxi = Taxi(1000,"택시")
    car3.달린다()
}

open class Car(var 종류:String){
    val 제조사:String=""
    val 색상:String=""
    fun 달린다(){
        println("${종류}가(이) 달린다.")
    }
    fun 속도올리기(){
    }
    fun 속도내리기(){
    }
}

class Bus:Car{
    val 인원수:Int=0
    constructor():super("버스"){
    }
    fun 노선확인하기(){
    }
}

class Truck:Car{
    val 무게:Int=0
    constructor():super("트럭"){
    }
    fun 짐올리기(){
    }
}

class Taxi(var 기본요금:Int,종류:String):Car(종류){
    fun 손님태우기(){
    }
}

