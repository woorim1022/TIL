package kr.multicampus.kotlin.oop.ploy

//10가지 종류의 메소드가 있다고 가정 -
class SenderLogic {
    fun run(obj:Sender?){
        //사용자가 선택한 기능을 구현하고 있는 객체의 send메소드 호출
        obj?.send()
    }
}