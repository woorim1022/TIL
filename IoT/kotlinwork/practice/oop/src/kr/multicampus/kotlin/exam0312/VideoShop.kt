package kr.multicampus.kotlin.exam0312

fun main(){
    val contents = arrayOf<Content>(Video("변호인(비디오)","new"),
                                    Video("탐정(비디오)","comic"),
                                    Video("헬로카봇(비디오)","child"),
                                    Book("감자(책)","1990"),
                                    Book("파이썬정복(책)","2020"),
                                    )

    for(c in contents){
        c.totalPrice()
        c.show()
    }

}