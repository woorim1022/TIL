package com.example.fragment.tab

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragment.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_tab_test2.*

class TabTest2 : AppCompatActivity() {
    var fragmentlist = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_test2)
        setActionBar(toolbar2)
        toolbar2.setTitleTextColor(Color.WHITE)
        tabs2.setTabTextColors(Color.BLUE, Color.BLACK)
        for(i in 0..9){
            val subfragment = SubMyFragment("${i}번째 프래그먼트")
            fragmentlist.add(subfragment)
        }


        val adapter = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return fragmentlist.size
            }
            override fun createFragment(position: Int): Fragment {
                return fragmentlist[position]
            }
        }
        tab_viewPager2.adapter = adapter


        //탭과 뷰페이저2를 연결하기
        //TabLayoutMediator 를 이용해서 탭과 뷰페이저를 연결
        //tab_viewPager2에 연결되어 있는 프래그먼트 개수만큼 TabLayoutMediator를 호출
        TabLayoutMediator(tabs2, tab_viewPager2){tab, position ->
            tab.text = "탭${position}"
        }.attach()
    }
}