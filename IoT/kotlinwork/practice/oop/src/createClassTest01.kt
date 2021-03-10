fun main(){
    val obj1:MyClass = MyClass() // obj1 <- 참조형 변수, MyClass() <- 인스턴스화
    val obj2:MyClass = MyClass()
    println("obj1:$obj1")
    println("obj2:$obj2")
    val obj3:Person = Person() // obj3 <- 참조형 변수
    println("Person의 age:${obj3.age}")
    println("Person의 telNum:${obj3.telNum}")
    obj3.print()

}

//클래스 작성방법 - 구성요소 없이 작성 가능
class MyClass{

}

//클래스 작성방법 - Value를 저장하는 객체, Value를 Object로 변환하기 위한 객체
//                                      ------
//                                         사용자가 입력한 값, DB에서 가져온 값
class Person{
    val age = 0
    var telNum = 0
    //멤버메서드 - Person이라는 객체가 갖고 있는 기능 : 함수와 동일한 방법으로 정의
    fun print(){
        println("print=> age:$age,telnum:$telNum")
    }
}