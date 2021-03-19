package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_progress_bar_test.*

class ProgressBarTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar_test)
        btngetValue.setOnClickListener{
            txtdisplay.text = " 현재값:${progressBar4.progress}"
        }
        btnsetup.setOnClickListener{
            progressBar4.progress = 89
        }
        btnup.setOnClickListener{
            progressBar4.incrementProgressBy(10)
        }
        btndown.setOnClickListener{
            progressBar4.incrementProgressBy(-10)
        }
//        btnstart.setOnClickListener{
//            for(i in 1..100){
//                progressBar5.progress += 5
//            }
//        }

    }
}