package kr.multicampus.kotlin.exam0312_2

class Dog(speed:Int):Animal(speed){
    override fun run(hours:Int) {
        //이동거리 누적되어 distance 변수에 저장
        distance = (hours.toDouble()/2 * speed).toDouble()
    }

}
