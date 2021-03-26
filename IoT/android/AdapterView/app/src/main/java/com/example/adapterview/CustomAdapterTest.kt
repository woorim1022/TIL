package com.example.adapterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adapterview.customizing.MyAdapter
import com.example.adapterview.customizing.User
import com.example.adapterview.customizing.MyAdapter_step01
import com.example.adapterview.customizing.MyAdapter_step02
import kotlinx.android.synthetic.main.activity_custom_adapter_test.*

//내가 만든 어댑터를 이용해서 리스트뷰를 만들어 주는 액티비티
class CustomAdapterTest : AppCompatActivity() {
    val datalist = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_adapter_test)
        //1. 리스트에 출력할 데이터 받아오기(DB, 네트워크, 리소스, 파일, 직접입력.....)
        for(i in 1..20){
            val user = User(R.drawable.ic_launcher_background, "name$i", "00000$i")
            datalist.add(user)
        }
        //2. 어댑터생성하기
        val adapter = MyAdapter(this, R.layout.custrow, datalist)

        //3. ListView에 어댑터 연결하기
        custlist.adapter = adapter

    }
}