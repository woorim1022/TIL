package com.example.mqttclienttest.network

import java.util.*

class BoardData(var boardNo:Int,var title:String, var content:String, var writer:String,
                var write_date:String){
    override fun toString(): String {
        return "$boardNo, $title, $content, $writer, $write_date"
    }
}