package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.lifecycle.*

class LifeCycleActivity : AppCompatActivity() {
    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lifecycle)
        Log.d("lifecycle","Activity********************>>onCreate()호출..")
        firstbtn.setOnClickListener{
            setFragment("first")
        }
        secondbtn.setOnClickListener{
            setFragment("second")
        }
    }
    //onCreate다음에 호출되는 메소드(액티비티실행 -2)
    override fun onStart() {
        super.onStart()
        Log.d("lifecycle","Activity********************>>onStart()호출..")
    }
    //onStart다음에 호출되는 메소드(액티비티실행 -3)
    override fun onResume() {
        super.onResume()
        Log.d("lifecycle","Activity********************>>onResume()호출..")
    }
    //일시정지 상태로 바뀔때 호출되는 메소드
    override fun onPause() {
        super.onPause()
        Log.d("lifecycle","Activity********************>>onPause()호출..")
    }
    //일시정지나 종료 상태로 바뀔때 onPause다음으로 실행되는 메소드
    override fun onStop() {
        super.onStop()
        Log.d("lifecycle","Activity********************>>onStop()호출..")
    }
    //앱이 종료될때 호출되는 메소드
    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle","Activity********************>>onDestroy()호출..")
    }
    fun setFragment(name:String){
        var fragmentManager = supportFragmentManager

        val transaction = fragmentManager.beginTransaction()
        when(name){
            "first" -> {
                transaction.replace(R.id.container2,firstFragment)
                transaction.addToBackStack("first")
            }
            "second" -> {
                transaction.replace(R.id.container2,secondFragment)
                transaction.addToBackStack("second")
            }
        }
        transaction.commit()
    }

}