import kr.multicampus.kotlin.insa.*
import java.util.*

fun main(){
    val key: Scanner = Scanner(System.`in`)

    var account:Account = Account("111-222-333",1000000)
    do{
        println("1. 입금하기")
        println("2. 출금하기")
        println("3. 잔액조회")
        println("4. 종료")
        var menu:String = key.next()
        println("*************************************************")
        when(menu){
            "1" -> account.deposit(500000)
            "2" -> account.withdraw(500000)
            "3" -> account.view()
            else -> break
        }
    }while(true)
}