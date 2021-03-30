package com.example.fragment.change.exam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.fragment.R
import kotlinx.android.synthetic.main.activity_fragment_exam02.*

//액티비티에서 프래그먼트의 데이터를 추출
class FragmentExam02 : AppCompatActivity() {
    var view1:RegisterFragment? =null
    var view2:LoginFragment? =null
    var view3:MyPageFragment? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_exam02)
        view1 = RegisterFragment()
        view2 = LoginFragment()
        view3 = MyPageFragment()
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.change_exam_container, view2!!)
        transaction.commit()

        btn_get.setOnClickListener {
//            maindata.setText(view1?.senddata())
            val obj = manager.findFragmentById(R.id.change_exam_container) as RegisterFragment
            maindata.setText(obj.senddata())
        }
    }
    fun btn_click(view: View){
        setFragment(view.getTag().toString())
    }
    fun setFragment(tag:String){
        var exam_manager = supportFragmentManager
        var transaction = exam_manager.beginTransaction()
        when(tag){
            "register" -> transaction.replace(R.id.change_exam_container,view1!!)
            "login" -> transaction.replace(R.id.change_exam_container,view2!!)
            "mypage" -> transaction.replace(R.id.change_exam_container,view3!!)
        }
        transaction.commit()

    }
}