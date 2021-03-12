package kr.multicampus.kotlin.exam0312_2

import kr.multicampus.kotlin.oop.ploy.Inter1

fun main(){
    var dog:Animal = Dog(8)
    var chicken:Animal = Chicken(3)
    var cheatableChicken:Cheatable = Chicken(5)
    cheatableChicken.fly()
    cheatableChicken as Chicken

    for (i in 1..3){
        dog.run(i)
        chicken.run(i)
        cheatableChicken.run(i)
        println("""$i 시간 후
        |개의 이동거리 : ${dog.getDistance()}
        |닭의 이동거리 : ${chicken.getDistance()}
        |날으는 닭의 이동거리 : ${cheatableChicken.getDistance()}
    """.trimMargin())
        println()
    }


}