package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.exam_secondview.*

class UseObjectSecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exam_secondview)
        var objintent = intent
        var obj = objintent.getParcelableExtra<User>("myobj")
        textView4.text = "이름: ${obj?.myname}, 전화번호 : ${obj?.telNum}"
        btn_finish.text = "끝~~"
        btn_finish.setOnClickListener{
            finish()
        }


    }
}