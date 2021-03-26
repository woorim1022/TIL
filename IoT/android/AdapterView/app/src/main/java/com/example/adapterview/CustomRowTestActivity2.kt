package com.example.adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.list_view_test.*

class CustomRowTestActivity2 : AppCompatActivity() {
    var listdata = ArrayList<HashMap<String,Any>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view_test)

        var item = HashMap<String,Any>()
        item["name"] = "이민호"
        item["image"] = R.drawable.kimdong
        item["text"] = "멋져"
        listdata.add(item)

        item = HashMap<String,Any>()
        item["name"] = "테리우스"
        item["image"] = R.drawable.ansoccer
        item["text"] = "간지"
        listdata.add(item)

        item = HashMap<String,Any>()
        item["name"] = "차붐"
        item["image"] = R.drawable.chasoccer
        item["text"] = "차붐!!"
        listdata.add(item)

        item = HashMap<String,Any>()
        item["name"] = "어준쓰"
        item["image"] = R.drawable.kbr
        item["text"] = "으"
        listdata.add(item)

        item = HashMap<String,Any>()
        item["name"] = "장김"
        item["image"] = R.drawable.jjangkim
        item["text"] = "모르겟다"
        listdata.add(item)

        val adapter = SimpleAdapter(
            this,
            listdata,
            R.layout.custrow,
            arrayOf("name","image","text"),
            intArrayOf(R.id.txtcust1,R.id.myimg,R.id.txtcust2)
        )
        listview1.adapter = adapter
    }
}