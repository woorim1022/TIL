package com.example.fragment.tabview.exam

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragment.R
import com.example.fragment.change.exam.LoginFragment
import com.example.fragment.change.exam.MyPageFragment
import com.example.fragment.change.exam.RegisterFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tab_test3.*

class TabExam : FragmentActivity() {
    var view1 = RegisterFragment()
    var view2 = LoginFragment()
    var view3 = MyPageFragment()
    var view4 = UserListFragment_Exam()
    val fragmentlist = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_test3)

        //액션바처럼 사용하기 위해
        setActionBar(toolbar_exam)
        toolbar_exam.setTitleTextColor(Color.WHITE)
        tabs_exam.setTabTextColors(Color.BLUE, Color.BLACK)
        fragmentlist.add(view1)
        fragmentlist.add(view2)
        fragmentlist.add(view3)
        fragmentlist.add(view4)


        val adapter = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return fragmentlist.size
            }
            override fun createFragment(position: Int): Fragment {
                return fragmentlist[position]
            }
        }
        viewpager_exam.adapter = adapter

        TabLayoutMediator(tabs_exam,viewpager_exam){tab,position ->
            when(position) {
                0 -> tab.text = "가입"
                1 -> tab.text = "로그인"
                2 -> tab.text = "마이페이지"
                3 -> tab.text = "회원목록"
            }
        }.attach()
    }
}