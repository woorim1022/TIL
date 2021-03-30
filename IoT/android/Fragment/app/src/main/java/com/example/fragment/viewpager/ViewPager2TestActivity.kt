package com.example.fragment.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragment.R
import com.example.fragment.change.exam.LoginFragment
import com.example.fragment.change.exam.MyPageFragment
import com.example.fragment.change.exam.RegisterFragment
import kotlinx.android.synthetic.main.activity_view_pager2_test.*

//ViewPager2는 프래그먼트를 ViewPager로 보여주기 위해서 편리한 기능을 제공해주는 뷰
//FragmentActivity() 는 액션바가 제공되지 않는다
    // --> toolbar를 따로 만들어줘서 액션바를 대체한다.
class ViewPager2TestActivity : FragmentActivity() {
    //1. ViewPager에서 보여줄 프래그먼트들을 정의
    var view1 = RegisterFragment()
    var view2 = LoginFragment()
    var view3 = MyPageFragment()
    val fragmentlist = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager2_test)
        fragmentlist.add(view1)
        fragmentlist.add(view2)
        fragmentlist.add(view3)
        setActionBar(toolbar)

        //2. ViewPager2도 어댑터가 있어야 하므로 어댑터를 커스터마이징
        // 어댑터의 생성자에서 FragmentActivity를 요구하고 parent 액티비티를 만들 때
        //FragmentActivity로 만들어야 한다.
        val adapter = object : FragmentStateAdapter(this){
            //ViewPager2를 통해 보여줄 프래그먼트의 개수
            override fun getItemCount(): Int {
                return fragmentlist.size
            }

            //ViewPager2에 보여줄 프래그먼트를 생성해서 리턴
            override fun createFragment(position: Int): Fragment {
                return fragmentlist[position]
            }
        }

        //3. ViewPager2에 어댑터 연결하기
        pager2.adapter = adapter
    }
}