package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.exam_secondview.*
import kotlinx.android.synthetic.main.second.*

class ExamSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exam_secondview)

        var returnIntent = intent
        //인텐트 객체에서 공유된 값을 꺼내기4
        val msg = returnIntent.getStringExtra("name")
        val data = returnIntent.getStringExtra("telNum")

        textView4.setText("입력한 id : $msg, 입력한 pass: $data")

        btn_finish.setOnClickListener {
            if(checkBox.isChecked){
                returnIntent.putExtra("returndata","우수회원설정")
            }else{
                returnIntent.putExtra("returndata","")
            }
            setResult(1,returnIntent)
            //액티비티종료하기
            finish()
        }
    }
}