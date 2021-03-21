package com.example.basicview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.text_test2.*

//EditText의 이벤트처리2
class TextTestActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.text_test2)
        //EditText에 문자열을 입력하는 동안 발생하는 이벤트에 대한 처리
        var listener = object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                info1.text = "before:$s"
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                info2.text = "change:$s"
            }
            override fun afterTextChanged(s: Editable?) {
                info3.text = "after:$s"
            }
        }
        mytext2.addTextChangedListener(listener)

        //입력이 끝난 후에 포커스가 사라지도록 키보드가 없어지도록
        //                                ------------------------
        //                                   안드로이드 OS내부에서 제공되는 시스템을 제어하는 기능(시스템서비스)을 사용   XXXXXXXXXManager
        btn_getdata.setOnClickListener {
            info1.text = mytext2.text
            mytext2.setText("")
            //getSystemService는 안드로이드 OS내부에서 제공되는 기능을 직접 구현하기 위해 제공되는 메소드로
            //제공되는 시스템의 상수명을 입력하면 받아와서 직접 제어할 수 있다.
            //제공되는 시스템기능이 다양하므로 최상위 클래스인 Object로 리턴 -> 따라서 사용하려고 하는 클래스로 캐스팅해야 한다.
            var myservice = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            
        }
    }
}




































