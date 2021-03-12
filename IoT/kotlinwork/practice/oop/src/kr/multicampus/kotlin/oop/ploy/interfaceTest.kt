package kr.multicampus.kotlin.oop.ploy


fun main(){
    //SubInter타입 가능
    val obj1:SubInter = SubInter()
    obj1.method()
    //SuperInter타입으로 선언 가능
    val obj2:SuperInter = SubInter()
    obj2.test()
    //Inter1이라는 interface를 구현하고 있으므로(구현은 상속처럼 취급) Inter1 타입으로 정의 가능
    val obj3:Inter1 = SubInter()
    obj3.display()
    //Inter2 타입으로 정의 가능
    val obj4:Inter2 = SubInter()
    obj4.show()
}

interface Inter1{
    fun display()
}

interface Inter2{
    fun show()
}

open class SuperInter{
    fun test(){
        println("SuperInter클래스의 일반메소드")
    }
}
class SubInter:SuperInter(),Inter1,Inter2{
    fun method(){
        println("내 메소드")
    }
    override fun display() {
        println("Inter1의 추상메소드 display 오버라이딩")
    }

    override fun show() {
        println("Inter2의 추상메소드 show 오버라이딩")
    }

}
