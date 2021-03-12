package kr.multicampus.kotlin.basic


//listOf 메소드를 이용해서 List객체를 생성하면 불변
//mutableListOf를 이용해서 List객체를 생성하면 가변(원본을 수정할 수 있다)
fun main(){
    val list1 = listOf(10,20,30,40,50)
    val list2 = listOf("python","c","Kotlin","android")
    //list1, list2가 List 클래스를 참조하는 참조변수만 출력하면 참조변수의 tostring메소드 호출하는 것과 동일
    //list1은 list1.toString()이 생략
    println("list1:$list1")
    println("list1:${list1.toString()}")
    println("list2:$list2")
    println("list2:${list2.toString()}")

    for(item in list1){
        println("item:$item")
    }
    println("size:${list1.size}")
    println("list1의 0번요소:${list1[0]}")

//    list1.add(30)

    println("**********************************")
    val list3 = mutableListOf<Int>(20,30,40,50,60)
    val list4 = mutableListOf("python","c","Kotlin","android")
    list3.add(70)
    println("list3:$list3")
    list4.add("aaaaa")
    list4.add("bbbb")
    println("list4:$list4")
    println("**********************************")
    list3.addAll(listOf(400,3000,300))
    list4.add(2,"jquery")
    println("list3:$list3")
    println("list4:$list4")

    list4.set(2,"javascript")
    list3.removeAt(1)
    println("**********************************")
    println("list3:$list3")
    println("list4:$list4")

    list3.removeAll(listOf(3000,300))
    println("**********************************")
    println("list3:$list3")
}