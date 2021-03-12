package kr.multicampus.kotlin.basic

fun main(){
    var myarr = intArrayOf(10,20,30,40,50)
    //함수호출 후 리턴받은 List에 저장된 값을 출력하기
    //함수호출 후 리턴받은 Map 에 저장된 값을 출력하기
    println("list : ${listfun(myarr)}")
    println("map : ${mapfun(myarr)}")

}


//함수를 정의
//=> 매개변수로 배열을 전달받아서 List로 변환해서 리턴하기

//함수를 정의
//=> 매개변수로 배열을 전달받고 Map으로 변환해서 리턴하기
//     Map의 키는 배열요소에 10을 더한 값으로 처리
fun listfun(myarr:IntArray):List<Int>{
    var list = mutableListOf<Int>()
    for (i in myarr){
        list.add(i)
    }
    return list
}

fun mapfun(myarr:IntArray):Map<Int,Int>{
    var map = mutableMapOf<Int,Int>()
    for (i in myarr){
        map.put(i+10,i)
    }
    return map
}