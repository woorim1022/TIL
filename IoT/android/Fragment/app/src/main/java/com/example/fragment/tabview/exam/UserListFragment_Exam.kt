package com.example.fragment.tabview.exam

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import com.example.fragment.R
import kotlinx.android.synthetic.main.listfragment_view.*


//ListFragment() - 자체가 리스트를 포함하고 있는 프래그먼트
class UserListFragment_Exam : ListFragment() {
    //fragment뷰가 만들어질때 호출되는 메소드
    //액티비티에 배치될때 호출되는 메소드 - view를 그리기 위해서 호출하는 메소드
    var data=
        arrayOf<String>("이민호", "공유", "소지섭", "이동욱", "류준열", "정우성")
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        Log.d("lifecycle", "Fragment:onCreateView()")
        val view =  inflater.inflate(R.layout.listfragment_view, container, false)
        listAdapter = ArrayAdapter<String>(activity as TabExam,
                                            android.R.layout.simple_list_item_1,
                                            android.R.id.text1, data)
        //프로퍼티로 접근
//        listAdapter = adapter
        return view
    }

    //세 번째 매개변수로 각 항목의 index
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        listfrag_text.text = data[position]
    }
}