import kr.multicampus.kotlin.insa.*

fun main(){
    var student:Student = Student("철수",20,11111)
    var teacher:Teacher = Teacher("영희",30,"JAVA")
    var staff:Staff = Staff("영수",40,"교무과")
    student.print()
    teacher.print()
    staff.print()
}