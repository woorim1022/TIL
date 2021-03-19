package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_check_box_test.*

//Checkbox 사용
//Checkbox 의 주요 속성
//  text, checked
//isChecked -> 현재 체크박스의 상태값을 true(체크박스가 선택되어 있는 상태) | false(체크박스의 선택이 해제된 상태) 로 리턴

class CheckBoxTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_box_test)
        var listener1 = CheckBoxTestListener()
        checkbtn1.setOnClickListener(listener1)
        checkbtn2.setOnClickListener(listener1)
        checkbtn3.setOnClickListener(listener1)
        checkbtn4.setOnClickListener(listener1)

        checkBox1.setOnCheckedChangeListener(listener1)
        checkBox2.setOnCheckedChangeListener(listener1)
        checkBox3.setOnCheckedChangeListener(listener1)
    }
    //CheckBoxTest 액티비티를 구성하는 위젯에서 발생하는 모든 이벤트를 처리하는 리스너
    //===> inner클래스로 작성하나 별도의 파일로 클래스를 구성해서 작성하기도 한다.
    internal inner class CheckBoxTestListener:CompoundButton.OnCheckedChangeListener, View.OnClickListener{

        //체크박스의 상태를 TextView에 출력
        fun getCheckStatus(){
            if(checkBox1.isChecked){    //isChecked에 대한 getter 작업
                checkinfo.append("checkbox1번 체크박스가 설정\n")
            }
            if(checkBox2.isChecked){
                checkinfo.append("checkbox2번 체크박스가 설정\n")
            }
            if(checkBox3.isChecked){
                checkinfo.append("checkbox3번 체크박스가 설정\n")
            }
        }
        fun setCheck(){
            checkBox1.isChecked = true //isChecked에 대한 setter 작업
            checkBox2.isChecked = true //isChecked에 대한 setter 작업
            checkBox3.isChecked = true //isChecked에 대한 setter 작업
        }
        fun clearCheck(){
            checkBox1.isChecked = false //isChecked에 대한 setter 작업
            checkBox2.isChecked = false //isChecked에 대한 setter 작업
            checkBox3.isChecked = false //isChecked에 대한 setter 작업
        }
        fun checkToggle(){
            checkBox1.toggle()  //toggle : 현재 상태의 반대로 변경ㅇ
            checkBox2.toggle()
            checkBox3.toggle()
        }

        override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
            Log.d("Checkbox_test", buttonView?.getTag().toString() +"객체의 값:"+ buttonView.toString()+"선택유무"+isChecked)
        }

        override fun onClick(v: View?) {
            when(v?.id){
                R.id.checkbtn1 -> setCheck()
                R.id.checkbtn2 -> getCheckStatus()
                R.id.checkbtn3 -> clearCheck()
                R.id.checkbtn4 -> checkToggle()
            }
        }

    }
}
