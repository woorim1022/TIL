package kr.multicampus.kotlin.exam0312_2

open abstract class Animal(var speed:Int){
    var distance:Double ?= 0.0

    open abstract fun run(hours:Int)

    fun getDistance():Double{
        return this.distance!!
    }
}
