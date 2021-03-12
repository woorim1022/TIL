package kr.multicampus.kotlin.basic

fun main(){
    val myarr1 =arrayOf(10,10.5,false,'A',"문자열")
    println(myarr1)
    println(myarr1.contentToString())

    println("**************************************************")
    val myarr2 = intArrayOf(10,20,30,40,50)
    println(myarr2)
    println(myarr2.contentToString())

    //arrayOf<데이터타입> - Generic
    println("**************************************************")
    val myarr3 = arrayOf<String>("문자열1","문자열2")
    println(myarr3)
    println(myarr3.contentToString())

    //다차원배열
    println("**************************************************")
    val arr2D = arrayOf(
                    arrayOf(10,20,30,40,50),
                    arrayOf(60,70,80,90,100),
                    arrayOf(110,120,130,140,150)
                )
    println(arr2D)
    println(arr2D.contentDeepToString())
    for(item in arr2D){
        for(i in item){
            print("$i\t")
        }
        println()
    }

    //배열요소 액세스
    println("**************************************************")
    println("myarr의 0번요소:${myarr2[0]}")
    println("myarr의 1번요소:${myarr2[1]}")
    println("myarr의 2번요소:${myarr2.get(2)}")
    println("myarr의 3번요소:${myarr2.get(3)}")
    println("**************************************************")
    println("myarr2:${myarr2.contentToString()}")
    myarr2[0] = 1000
    myarr2.set(1,2000)
    println("myarr2:${myarr2.contentToString()}")

    //배열의 길이
    println("**************************************************")
    println("myarr2의 요소의 개수:${myarr2.size}")
}