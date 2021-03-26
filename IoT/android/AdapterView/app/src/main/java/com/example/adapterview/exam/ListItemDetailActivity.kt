package com.example.adapterview.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adapterview.R
import kotlinx.android.synthetic.main.activity_list_item_detail.*

class ListItemDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item_detail)
        //안드로이드 os에서 인텐트 꺼내오기
        var listIntent = intent

        var myobj = listIntent.getParcelableExtra<PersonValue>("myobj")
        detail_img.setImageResource((myobj!!.myImg))
        detail_name.setText(myobj.name)
        detail_date.setText(myobj.date)
        detail_info.setText(myobj.info)

        back.setOnClickListener {
            finish()
        }
        delete.setOnClickListener {

            finish()
        }
        update.setOnClickListener {
            var myobj = PersonValue()
            myobj.name = detail_name.text.toString()
            myobj.info = detail_info.text.toString()
            myobj.date = detail_date.text.toString()
            listIntent.putExtra("myobj",myobj)
            listIntent.putExtra("check",detail_check.isChecked)
            setResult(111,listIntent)
            finish()
        }


    }
}