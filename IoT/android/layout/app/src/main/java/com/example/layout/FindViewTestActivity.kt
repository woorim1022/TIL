package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

//액티비티에 있는 뷰에 코드를 연결
//버튼이 눌려졌을 때 처리 작업 수행
//1. xml문서 내부에 정의되서 객체로 생성된 View를 찾아와야 한다.
//2. 버튼이 눌려졌을 때 처리할 기능들을 클래스로 정의
//3. 버튼과 2번에서 정의한 기능을 연결
class FindViewTestActivity : AppCompatActivity(), View.OnClickListener {
    var btn: Button?=null
    var result: TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
       xml을 파싱해서 만들어 놓은 모든 위젯을 초기화해서 액티비티에 배치
       */
        setContentView(R.layout.activity_find_view_test)
        //1. 직접 찾아와서 사용하기=============
        //      반드시 setContentView다음에 찾아야 한다.
        //      멤버변수 btn과 result를 xml에 정의되어 있는 Button과 TextView와 연결
        //btn = findViewById("xml에 등록된 아이디명") -> 리소스로 관리가 된다. R 파일
        //R이라는 클래스는 프로젝트 안에 추가된 리소스를 관리하는 파일 - 레이아웃 파일, 이미지파일, 애니메이션, 배열, 문자열, id...
        btn = findViewById(R.id.btnClick)
        btn?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //
        btn?.setText(Date().toString())//버튼의 문자열을 오늘의 날짜 정보로 변경
        var myval = btn?.text
        Toast.makeText(this,"android....start..."+myval,Toast.LENGTH_LONG).show()

        Log.d("layout","android start...")
    }
}