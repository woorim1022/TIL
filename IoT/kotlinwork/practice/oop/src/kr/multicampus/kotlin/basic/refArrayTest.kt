package kr.multicampus.kotlin.basic

//클래스를 배열에 요소로 저장
fun main(){
    //SubA와 SubB를 하나의 배열로 선언하고 요소에 저장 
    //배열의 선언과 생성 - 배열요소 없이 배열을 생성
    //Super 타입의 배열요소 3개인 배열을 선언하고 생성 - 배열에 다형성 적용
    var myarr = arrayOfNulls<Super>(3)
    myarr[0] = SubA()
    myarr[1] = SubA()
    myarr[2] = SubB()
    // size 초과하면 ArrayIndexOutOfBoundsException 발생
    myarr[3] = SubB()
    for(element in myarr){
        println("요소:$element")
    }
}
open class Super{

}
class SubA:Super(){

}
class SubB:Super(){
    
}