package kr.multicampus.kotlin.oop

//******************상속관계에서 생성자 활용, super***************************
fun main(){
    var obj:ChildClass4 = ChildClass4(25, "인천", "김우림")
    println("객체의 값:${obj.getData()}")

    var obj2:ChildClass5 = ChildClass5(111, "서울", "woorim")
    println("객체의 값:${obj2.getData()}")
}

//부모클래스에 주생성자가 정의되어 있는 경우 반드시 상속받을 때 주생성자를 호출해야 한다.
//클래스의 주생성자를 정의하면 매개변수가 없는 생성자는 자동으로 제공하지 않는다.
open class ParentClass(var name:String){
    var superVal = 100
    constructor():this(""){

    }
    fun display(){
        println("부모클래스의 display")
    }
}

//Parent 클래스를 상속받을 때는 반드시 name 값을 지정해 주어야 한다
class ChildClass:ParentClass("차"){
}

class ChildClass2:ParentClass{
    constructor():super("차"){
    }
}

// 부모클래스에 정의된 생성자 중 아무거나 호출하면 된다
// 부모클래스에 매개변수가 없는 생성자가 있기 때문에 그걸 호출한 것임
class ChildClass3:ParentClass(){
}

class ChildClass4:ParentClass{
    var age:Int = 0
    var addr:String=""
    constructor(age:Int,addr:String,name:String):super(name){
        this.age=age
        this.addr=addr
    }
     fun getData(): String {
        return "ChildClass4(age=$age, addr='$addr', name='$name')"
    }
}

// ParentClass를 상속 - ParentClass의 주생성자를 호출
// ChildClass5를 정의할 때 Taxi클래스와 같은 유형으로 정의하기(코틀린언어에서의 권고사항)
class ChildClass5(var age:Int,var addr:String,name:String):ParentClass(name){
    fun getData(): String {
        return "ChildClass4(age=$age, addr='$addr', name='$name')"
    }
}