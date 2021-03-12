package kr.multicampus.kotlin.oop


fun main(){
    //obj1은 kr.multicampus.kotlin.oop.SubA 타입이고 kr.multicampus.kotlin.oop.SubA 객체를 참조하고 있다.
    val obj1:SubA = SubA()
    obj1.display()
    obj1.show()
    obj1.test()
    println("******************************")

    //상속관계에 있는 경우 상위타입으로 변수를 선언하고 하위객체를 생성해서 참조할 수 있다.
    //=> 묵시적으로 형변환이 발생, 코틀린에서는 이를 스마트형변환이라 한다.
    //obj2는 SuperA타입이고 SubA객체를 참조하고 있다
    //객체를 참조하는 변수는 선언된 타입의 멤버만 접근할 수 있다.
    //단, 오버라이딩된 메소드가 있으면 오버라이딩된 메소드가 실행된다.
    val obj2:SuperA = SubA()
    obj2.display()
//  obj2.show()  //show()는 SubA타입의 메소드이므로 접근할 수 없다.
    obj2.test()
}

open class SuperA{
    fun test(){
        println("Super의 test")
    }
    open fun display(){
        println("Super의 display")
    }
}
class SubA:SuperA(){
    fun show(){
        println("show")
    }
    override fun display(){
        println("Sub의 display")
    }
}