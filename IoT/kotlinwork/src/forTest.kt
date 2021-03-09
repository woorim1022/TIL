fun main(){
    /*
    * 배열처럼 여러 개의 데이터를 저장하는 자료구조의 요소들을
    * 이용하려고 할 때 사용
    * 값의 개수만큼 반복실행
    * for(변수명 in 배열과 같은 자료구조){
*           데이터를 여러 개 보관하는 변수나 구조
    * }
    *
    * while(조건){
    *   true나 false를 리턴하는 연산, 변수....
    *   //반복해서 실행할 명령문
    * }
    * do{
    *   //반복해서 실행할 명령문
    * }while(조건)
    *
    * */
    val numRange = 1..10
    for(i in numRange){ // i는 임의로 선언하는 변수
        println("값:$i")
    }

    println("***************************")
    val numRange2 = 1..10 step 2
    for(item in numRange2){ // i는 임의로 선언하는 변수
        println("값:$item")
    }

    println("***************************")
    val numRange3 = 10 downTo 1
    for(item in numRange3){ // i는 임의로 선언하는 변수
        println("값:$item")
    }

    println("***************************")
    val numRange4 = 100 downTo 1 step 2
    for(item in numRange4){ // i는 임의로 선언하는 변수
        println("값:$item")
    }
}