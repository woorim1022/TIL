package com.example.intent.exam

class Person {
    var myImg = 0
    var name: String? = null
    var date: String? = null
    var info: String? = null

    constructor(myImg: Int, name: String?, date: String?, info: String?) {
        this.myImg = myImg
        this.name = name
        this.date = date
        this.info = info
    }

    override fun toString(): String {
        return "Person(myImg=$myImg, name=$name, date=$date, info=$info)"
    }


}