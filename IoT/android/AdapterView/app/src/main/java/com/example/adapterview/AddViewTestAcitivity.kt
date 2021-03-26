package com.example.adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout

class AddViewTestAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        //안드로이드에서 뷰의 크기나 배치는 해당 뷰의 부모 레이아웃에 의해서 결정이 된다.
        //부모레이아웃의 정보에 영향을 받는 속성들을 관리하는 객체가 LayoutParams
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)
        params.topMargin = 200
        params.gravity = Gravity.CENTER_HORIZONTAL

        //뷰를 직접 배치하는 경우 레이아웃에 정보를 설정해야 한다(너비, 높이, 방향....상위뷰에 대한 정보)
        //레이아웃 속성을 설정하는 경우 LayoutParams()메소드를 이용해서 생성해서 설정
        val btn = Button(this)
        btn.text = "코드로 만들어진 버튼"
        btn.layoutParams = params

        //Layout 에 버튼 추가
        layout.addView(btn)

        setContentView(layout)

        btn.setOnClickListener{
            val btn2 = Button(this)
            btn2.text = "이벤트로 만들어진 객체"
            layout.addView(btn2)
        }
    }
}