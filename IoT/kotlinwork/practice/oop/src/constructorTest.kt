fun main(){
    val obj1:Customer = Customer()
    var obj2:Customer = Customer(45, 101111)
    obj2.print()
    var obj3:Customer2 = Customer2(20, 777777)
    println("Customer2=> age:${obj3.age},telnum:${obj3.telNum}")
    var obj4:Customer3 = Customer3(10, 1234567)
    println("Customer3=> age:${obj4.age},telnum:${obj4.telNum}")

    val obj5:Customer4 = Customer4(20,"김우림",1111)
    println("Customer4=> age:${obj5.age},name:${obj5.name},telnum:${obj5.telNum}")
}

//============================생성자 정의하기 - 1 =============================
class Customer{
    var age:Int = 0
    var telNum = 0
    //constructor호출순서 : 2
    constructor(){
        println("매개변수가 없는 생성자")
    }
    //매개변수가 다른 constructor를 여러 개 생성할 수 있음
    //생성자 오버로딩이 가능하므로 여러 개를 정의하고 사용할 수 있다.
    constructor(age:Int, telNum:Int){
        this.age = age
        this.telNum = telNum
    }
    //init호출순서 : 1
    init{
        println("객체가 생성될 때 자동으로 실행되는 블럭")
    }
    fun print(){
        println("print=> age:$age,telnum:$telNum")
    }
}

//============================생성자 정의하기 - 2 ===================================
// 객체를 생성할 때 어떤 멤버변수를 초기화 해줄지 지정
// 주 생성자에서 변수를 정의할 때는 var를 적어줘야 한다
class Customer2 constructor(var age:Int,var telNum:Int){
}
// 클래스를 선언하며 생성자를 바로 정의하는 경우 constructor의 생략이 가능
class Customer3 (var age:Int,var telNum:Int){
}


//============================생성자 정의하기 - 3 =====================================
// 2번방법의 확장
// 주생성자(기본생성자)는 반드시 초기화해야 하는 변수를 정의
// age, name 은 반드시 초기화되어야 하지만 telNum은 안되어도 됨
class Customer4 constructor(var age:Int,var name:String){
    var telNum:Int=0
    //주생성자(기본생성자) 이외의 생성자를 보조생성자라 부른다
    //보조생성자는 반드시 주생성자(기본생성자)를 거친 후 실행되어야 한다.
    //  constructor(...):this(...){
    //      ...
    //  }
    constructor(age:Int, name:String, telNum:Int):this(age,name){
        this.telNum = telNum
    }
}