package com.example.fragment.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_circle_image_recycler_test.*

class CircleImageRecyclerTest_Exam : AppCompatActivity() {
    var datalist = ArrayList<CircleItem_Exam>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_image_recycler_test)
        //1. 데이터준비

        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.VERTICAL
        circle_list.layoutManager = manager

        datalist.add(CircleItem_Exam("공유의 도깨비",R.drawable.gong))
        datalist.add(CircleItem_Exam("장기용의 어쩌구",R.drawable.jang))
        datalist.add(CircleItem_Exam("정우성의 어쩌구",R.drawable.jung))
        datalist.add(CircleItem_Exam("이민호의 어쩌구",R.drawable.lee))
        datalist.add(CircleItem_Exam("어쩌구저쩌구",R.drawable.img01))
        datalist.add(CircleItem_Exam("소지섭 어쩌구",R.drawable.so))
        circle_list.adapter = CircleImageItemAdapter_Exam(this,R.layout.card_item_exam,datalist)
    }
}