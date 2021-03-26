package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_use_other_test.*

//다른 App에서 공유한 액티비티 실행
const val SELECT_ACTIVITY = 1
class UseOtherActivityTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_other_test)
        call_selectview_activity.setOnClickListener {
            //명시적 인텐트와 달리 암시적인텐트는 정확하게 실행할 클래스명을 모르므로 공유된 action명을 명시한다.
            var implicitIntent = Intent("com.exam.adapterView2")
            startActivity(implicitIntent)
        }
    }
}
