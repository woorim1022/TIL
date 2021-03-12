package kr.multicampus.kotlin.basic

//key, value 한쌍으로 데이터를 관리하는 경우 사용
/*
* mapOf : 불변형 Map(원본이 변경되지 않는다)
* */
fun main(){
    val map1 = mapOf<String,Int>("A01" to 10,"A02" to 20,"A03" to 30)
    println("***********************************")
    println("map1:$map1")

    val map2 = mutableMapOf<String,String>()
    println("map2:$map2")
    println("***********************************")
    map2.put("id","jang")
    map2.put("pass","1234")
    map2.put("name","장동건")
    map2.put("addr","jang")
    println("***********************************")
    println("map1:$map1")
    println("map2:$map2")
    println("map1:${map1.size}")
    println("map2:${map2.size}")
    println("***********************************")
    println("map1:${map1.get(1)}")
    println("map2:${map2["name"]}")
    println("***********************************")
    println("map1:${map1.keys}")
    println("map2:${map2.values}")

    println("***********************************")
    println("map1:${map1.containsKey("A01")}")
    println("map2:${map2.containsValue("A05")}")

}