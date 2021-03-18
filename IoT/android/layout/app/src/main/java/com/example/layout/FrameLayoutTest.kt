package com.example.layout

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_find_view_test.*
import kotlinx.android.synthetic.main.activity_frame_layout_test.*

class FrameLayoutTest : AppCompatActivity(), View.OnClickListener {
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_layout_test)
        login.setOnClickListener(this)
        register.setOnClickListener(this)
        detail.setOnClickListener(this)
        button12.setOnClickListener(this)
    }

    override fun onClick(v:View?) {
        when(v?.id){
            R.id.login -> {
                loginlayout.visibility = View.VISIBLE
                registerlayout.visibility = View.GONE
                detaillayout.visibility = View.GONE
            }
            R.id.register -> {
                loginlayout.visibility = View.GONE
                registerlayout.visibility = View.VISIBLE
                detaillayout.visibility = View.GONE
            }
            R.id.detail -> {
                loginlayout.visibility = View.GONE
                registerlayout.visibility = View.GONE
                detaillayout.visibility = View.VISIBLE
            }
            R.id.button12 -> {
                val show = {name:EditText,id:EditText,password:EditText ->
                    textView5?.setText(name.text.toString())
                    textView6?.setText(id.text.toString())
                    textView7?.setText(password.text.toString())
                }
                show(ename,eid,epassword)
            }
        }
    }

}