package com.example.fragment.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_view_pager.*

/* 화면 전환을 위해서 ViewPager 사용(ListView와 동일한 작업)
* 1. ViewPager 로 보여줄 View의 목록을 정의(Array, ArrayList)
* 2. Adapter커스터마이징
* 3. ViewPager에 Adapter를 연결
* */

class ViewPagerActivity : AppCompatActivity() {
    var viewList = ArrayList<View>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        //1. ViewPager에 담을 View 객체 생성
        val view1 = layoutInflater.inflate(R.layout.register,null)
        val view2 = layoutInflater.inflate(R.layout.login,null)
        val view3 = layoutInflater.inflate(R.layout.mypage,null)

        viewList.add(view1)
        viewList.add(view2)
        viewList.add(view3)

        //2. Adapter 커스터마이징
            //=> object 키워드란
            //      클래스를 정의할 때 사용하는 키워드 class, 코틀린에서 object 키워드로 클래스를 정의
            //                                                       ---------------------------
            //                                                            싱글톤객체를 정의 or 익명클래스 정의
        var adapter = object : PagerAdapter(){
            //ViewPager에 보여줄 뷰의 개수를 리턴
            override fun getCount(): Int {
                return viewList.size
            }
            //getView와 동일한 역할을 하는 메소드
            //ViewPager에서 보여줄 View객체를 생성해서 리턴
            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                pager1.addView(viewList[position])
                return viewList[position]
            }
            //instantiateItem메소드에서 리턴한 view를 사용할 것인지 여부를 결정
            override fun isViewFromObject(view: View, obj: Any): Boolean {
                return view==obj
            }
            //ViewPager에서 View가 사라질 때 제거하는 작업을 수행
            override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
                pager1.removeView(obj as View)
            }
        } //end Adapter(여기까지가 어댑터 영역)

        //3. ViewPager에 Adapter를 연결
        pager1.adapter = adapter



        //ViewPager에 이벤트 연결하기
        //화면이 전환될 때 마다 PageChange이벤트가 발생하고 그 이벤트가 발생했을 때
        //OnPageChangeListener의 메소드가 호출
        val listener1 = object:ViewPager.OnPageChangeListener{
            //페이지 상태가 변경되었을 때 호출되는 메소드
            override fun onPageScrollStateChanged(state: Int) {

            }
            //페이지 스크롤이 끝났을 때 호출되는 메소드
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                pager_text.text = "${position}번째 뷰가 선택됨"
            }
            //페이지를 선택했을 때 호출되는 메소드
            override fun onPageSelected(position: Int) {

            }
        }
        pager1.addOnPageChangeListener(listener1)

    }
}