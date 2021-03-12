package kr.multicampus.kotlin.basic

//배열을 제어할 수 있는 제공 메소드 - 배열의 원본을 변경하지 않고 해당 메소드를 적용한 결과로 배열을 만들어서 리턴
fun main(){
    val myarr = intArrayOf(10,20,30,40,50)
    //plus: 요소를 추가
    val myarr1 = myarr.plus(60)
    println("******************************************")
    println("myarr:${myarr1.contentToString()}")
    println("******************************************")
    println("myarr1:${myarr1.contentToString()}")

    //sliceArray : 지정한 범위의 요소를 추출해서 새로운 배열을 만들어서 리턴
    println("******************************************")
    val myarr2 = myarr.sliceArray(1..3)
    println("myarr2:${myarr2.contentToString()}")

    println("******************************************")
    println("myarr.first() : ${myarr.first()}")
    println("myarr.last() : ${myarr.last()}")
    println("myarr.indexOf(20) : ${myarr.indexOf(20)}")
    println("myarr.average() : ${myarr.average()}")
    println("myarr.sum() : ${myarr.sum()}")
    println("myarr.count() : ${myarr.count()}")
    println("myarr.contains(100) : ${myarr.contains(100)}")
    println("myarr.contains(50) : ${myarr.contains(50)}")
    println("myarr.contains(200) : ${200 in myarr}")
    println("myarr.contains(10) : ${10 in myarr}")

    println("******************************************")
    val myarr3 = arrayOf(50,100,98,77,23)
    val myarr4 = myarr3.sortedArray() //배열의 요소를 정렬(기본 : 오름차순)
    println(myarr4.contentToString())
    val myarr5 = myarr3.sortedArrayDescending() //배열의 요소를 정렬(기본 : 내림차순)
    println(myarr5.contentToString())


}
