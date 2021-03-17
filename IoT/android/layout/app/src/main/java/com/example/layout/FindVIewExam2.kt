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

class FindVIewExam2 : AppCompatActivity(), View.OnClickListener {
    var btnClick: Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_view_test)
        btnClick = findViewById(R.id.btnClick)
        btnClick?.setOnClickListener(this)

        btnClick2.setOnClickListener{
            Toast.makeText(this,"android...start...2",Toast.LENGTH_LONG).show()
            myimg?.setImageResource(R.drawable.dream02)
        }

        btnClick3.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext,"android...start...3",Toast.LENGTH_LONG).show()
                myimg?.setImageResource(R.drawable.beach)
            }
        })

        var mylistener = object :View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext,"android...start...4",Toast.LENGTH_LONG).show()
                myimg?.setImageResource(R.drawable.ic_launcher_background)
            }
        }
        btnClick4.setOnClickListener(mylistener)
    }

    override fun onClick(v: View?) {
        Toast.makeText(this,"android....start...",Toast.LENGTH_LONG).show()
        myimg?.setImageResource(R.drawable.dream01)
    }
}


