package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.second.*

class SecondActivity : AppCompatActivity() {
    //SecondActivity를 실행하면 MainActivity는 back stack으로 빠졌다가 뒤로가기나 종료하면 다시 전면에 나와서 출력됨
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)
        //MainActivity 가 공유한 데이터를 꺼내서 사용
        //SecondActivity가 실행되기 위해서 OS가 사용한 인텐트를 꺼내오기
        var firstIntent = intent
        //인텐트 객체에서 공유된 값을 꺼내기4
        val msg = firstIntent.getStringExtra("info")
        val data = firstIntent.getIntExtra("num",0)
        Toast.makeText(this,"추출한 값:$msg, $data", Toast.LENGTH_LONG).show()
        bt2.setOnClickListener {
            //액티비티종료하기
            finish()
        }
    }
}