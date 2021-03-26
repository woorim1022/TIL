package com.example.fragment.exam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragment.R
import kotlinx.android.synthetic.main.fragment_exam.*

class FragmentExam01 : AppCompatActivity(){
    val firstFragment = ViewFragment1()
    val secondFragment = ViewFragment2()
    val thirdFragment = ViewFragment3()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_exam)
        btn_first.setOnClickListener{
            setFragment("first")
        }
        btn_second.setOnClickListener{
            setFragment("second")
        }
        btn_third.setOnClickListener{
            setFragment("third")
        }
    }
    fun setFragment(name:String){
        var fragmentManager = supportFragmentManager

        val transaction = fragmentManager.beginTransaction()
        when(name){
            "first" -> {
                transaction.replace(R.id.container,firstFragment)
                transaction.addToBackStack("first")
            }
            "second" -> {
                transaction.replace(R.id.container,secondFragment)
                transaction.addToBackStack("second")
            }
            "third" -> {
                transaction.replace(R.id.container,thirdFragment)
                transaction.addToBackStack("third")
            }
        }
        transaction.commit()
    }
}