package kr.multicampus.kotlin.basic

fun main(){
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<String>()

    for(i in 1..10) {
        list1.add(i)
        if ( i%2 == 0){
            list2.add("False")
        }else{
            list2.add("True")
        }
    }

    println("list1: ${list1}")
    println("list2: ${list2}")
}
