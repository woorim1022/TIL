package com.example.fragment.tab

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.fragment.R
import com.example.fragment.change.exam.LoginFragment
import com.example.fragment.change.exam.MyPageFragment
import com.example.fragment.change.exam.RegisterFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_test1.*

class TabTest1Activity : AppCompatActivity() {
    var view1 = RegisterFragment()
    var view2 = LoginFragment()
    var view3 = MyPageFragment()
    val fragmentlist = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_test1)
        setSupportActionBar(toolbar)
//        fragmentlist.add(view1)
//        fragmentlist.add(view2)
//        fragmentlist.add(view3)
        toolbar.setTitleTextColor(Color.WHITE)
        tabs.setTabTextColors(Color.GRAY, Color.BLACK)
        //탭 추가
        tabs.addTab(tabs.newTab().setText("설정"))

        //처음 실행할 때 실행해서 보여줄 프래그먼트를 지정
        supportFragmentManager.beginTransaction().replace(R.id.tab_container1,view1).commit()

        //탭에 이벤트 연결하기
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
            //탭을 선택했을 때
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val position = tab?.position //탭의 순서를 받아오기
                Log.d("mytab","순서 : ${position}")
                var fragment:Fragment? = null
                when(position){
                    0 -> fragment = view1
                    1 -> fragment = view2
                    2 -> fragment = view3
                }
                supportFragmentManager.beginTransaction().replace(R.id.tab_container1,fragment!!).commit()
            }
        })//end tab event

        //하단 내비게이션 바에 이벤트 연결하기
        bottomNavi.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
//                Log.d("mytab","${item.toString()}")
                var view:Fragment ?= null
                when(item.itemId){
                    R.id.bottom_item1 -> view = view3
                    R.id.bottom_item2 -> view = view1
                    R.id.bottom_item3 -> view = view2
                }
                supportFragmentManager.beginTransaction().replace(R.id.tab_container1,view!!).commit()
                return false
            }

        })
    }
}
