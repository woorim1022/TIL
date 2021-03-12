package kr.multicampus.kotlin.exam0312_2

class Chicken(speed:Int):Animal(speed),Cheatable{
    override fun run(hours: Int) {
        distance = (hours * speed).toDouble()
    }
    override fun fly() {
        speed *= 2
    }
}
