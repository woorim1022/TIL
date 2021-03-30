package com.example.fragment.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_circle_image_recycler_test.*

class CircleImageRecyclerTest : AppCompatActivity() {
    var datalist = ArrayList<CircleItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_image_recycler_test)
        //1. 데이터준비

        val manager = LinearLayoutManager(this)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        circle_list.layoutManager = manager

        datalist.add(CircleItem(R.drawable.gong))
        datalist.add(CircleItem(R.drawable.jang))
        datalist.add(CircleItem(R.drawable.jung))
        datalist.add(CircleItem(R.drawable.lee))
        datalist.add(CircleItem(R.drawable.img01))
        datalist.add(CircleItem(R.drawable.so))
        circle_list.adapter = CircleImageItemAdapter(this,R.layout.circle_item,datalist)
    }
}