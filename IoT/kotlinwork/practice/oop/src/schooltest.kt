import kr.multicampus.kotlin.oop.Staff
import kr.multicampus.kotlin.oop.Student
import kr.multicampus.kotlin.oop.Teacher
import kr.multicampus.kotlin.oop.Person

fun main(){
    var student: Student = Student("철수",20,11111)
    var teacher: Teacher = Teacher("영희",30,"JAVA")
    var staff: Staff = Staff("영수",40,"교무과")
    student.print()
    teacher.print()
    staff.print()

    var o5: Person = Student("철수",20,11111)
    var o6: Person = Teacher("영희",30,"JAVA")
    var o7: Person = Staff("영수",40,"교무과")
}