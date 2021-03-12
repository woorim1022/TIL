package kr.multicampus.kotlin.exam0312

open abstract class Content(var title:String){
    var price:Int = 0
    open abstract fun totalPrice()
    fun show(){
        println("$title 의 가격은 $price 원 입니다")
    }
}
