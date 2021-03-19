package com.example.layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_progress_bar_test.*
import kotlinx.android.synthetic.main.activity_seek_bar_test.*
import kotlinx.android.synthetic.main.activity_seek_bar_test.view.*

class SeekBarTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_test)
        get.setOnClickListener{
            tx1.text = " 현재값:${seekBar.progress}"
            tx2.text = " 현재값:${seekBar2.progress}"
        }
        up.setOnClickListener{
            seekBar.progress = 3
            seekBar2.progress = 6
        }
        set.setOnClickListener{
            seekBar.incrementProgressBy(1)
            seekBar2.incrementProgressBy(1)
        }
        down.setOnClickListener{
            seekBar.incrementProgressBy(-1)
            seekBar2.incrementProgressBy(-1)
        }
    }
}