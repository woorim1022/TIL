package kr.multicampus.kotlin.insa

class Account constructor(var accId:String,var balance:Int){
    fun deposit(money:Int){
        balance += money
        println("잔액:$balance")
    }
    fun withdraw(money:Int){
        if (money <= balance) {
            balance -= money
            println("잔액:$balance")
        }
        else
            println("잔액부족")
    }
    fun view(){
        println("잔액:$balance")
    }
}