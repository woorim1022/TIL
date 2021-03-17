package com.example.layout

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class FindVIewExam : AppCompatActivity(), View.OnClickListener{
    var btn: Button?=null
    var data: TextView?=null
    var exam_result: TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.findview_exam )

        btn = findViewById(R.id.btnClick)
        data = findViewById(R.id.data)
        exam_result = findViewById(R.id.exam_result)
        btn?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var myval:String = exam_result?.text.toString() + data?.text.toString()
        exam_result?.setText(myval)
    }
}