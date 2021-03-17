package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_find_view_test.*
import java.util.*

//레이아웃파일에서 뷰를 찾아서 코드를 연결 - 1번방법
//동일한 이벤트를 발생시키는 위젯이 많은 경우 어떤 방법으로 처리해야 하는지?
class FindViewTestActivity3 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_view_test)
        btnClick.setOnClickListener(this)
        btnClick2.setOnClickListener(this)
        btnClick3.setOnClickListener(this)
        btnClick4.setOnClickListener(this)
        btnClick5.setOnClickListener(this)
        }
    //이벤트처리 - 매개변수로 View 타입의 변수를 정의하고 있다.
    //                      --------------------
    //                          클릭이벤트를 발생시키는 위젯의 종류가 많고 이벤트가 발생하는 시점에
    //                          어떤 위젯이 이벤트를 발생시키는 지 알아야 하므로
    override fun onClick(v:View?) {
        when(v?.id){
            R.id.btnClick -> {
                myimg.setImageResource(R.drawable.dream01)
            }
            R.id.btnClick2 -> {
                myimg.setImageResource(R.drawable.dream02)
            }
            R.id.btnClick3 -> {
                myimg.setImageResource(R.drawable.beach)
            }
            R.id.btnClick4 -> {
                myimg.setImageResource(R.drawable.ic_launcher_background)
            }
            R.id.btnClick5 -> {
                myimg.setImageResource(R.drawable.beach)
            }

        }
    }
}


