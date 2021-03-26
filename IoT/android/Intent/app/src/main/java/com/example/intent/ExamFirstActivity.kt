package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.first2.*
import kotlinx.android.synthetic.main.firstexam.*

const val BUTTON = 10
class ExamFirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.firstexam
        )

        Button01.setOnClickListener{
            val myIntent = Intent(this,ExamSecondActivity::class.java).apply {
                putExtra("name",EditText01.text.toString())
                putExtra("telNum", EditText02.text.toString())

            }

            startActivityForResult(myIntent, BUTTON)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            BUTTON -> first_return.text = data?.getStringExtra("returndata")
        }
    }
}





