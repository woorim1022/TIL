package com.example.intent

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("kim","OnCreate호출....")
        button.setOnClickListener{
            //SecondActivity를 실행하도록 의뢰하기 위해 인텐트를 생성
            //Context -> android os 내부에서 필요한 정보, 통신을 위한 기본내용 방법들을 담고 있는 객체
            //실행할 액티비티 클래스 파일명(코틀린으로 만들어진 클래스를 자바로 변환하고 컴파일까지 해서 만들어진 파일명)
            //자바는 컴파일하면 .class파일이 만들어짐 - 바이트코드...?
            //리플렉션(Reflection)에서 사용하는 연산자 :: -> ::class객체를 참조하라는 의미
            val firstIntent = Intent(this,SecondActivity::class.java).apply {
                //{}안의 scope가 Intent 객체에서 작업하는 것과 동일함
                putExtra("info","첫 번째 액티비티가 넘기는 메세지")
                putExtra("num", 20000)
            }

            
            //2. 데이터 공유하기
//            firstIntent.putExtra("info","첫 번째 액티비티가 넘기는 메시지")
//            firstIntent.putExtra("num", 10000)

            
            //액티비티를 실행하기 위해서 android OS에 의뢰
            startActivity(firstIntent)
        }
    }
    //onCreate다음에 호출되는 메소드(액티비티실행 -2)
    override fun onStart() {
        super.onStart()
        Log.d("kim","onStart()호출..")
    }
    //onStart다음에 호출되는 메소드(액티비티실행 -3)
    override fun onResume() {
        super.onResume()
        Log.d("kim","onResume()호출..")
    }
    //일시정지 상태로 바뀔때 호출되는 메소드
    override fun onPause() {
        super.onPause()
        Log.d("kim","onPause()호출..")
    }
    //일시정지나 종료 상태로 바뀔때 onPause다음으로 실행되는 메소드
    override fun onStop() {
        super.onStop()
        Log.d("kim","onStop()호출..")
    }
    //앱이 종료될때 호출되는 메소드
    override fun onDestroy() {
        super.onDestroy()
        Log.d("kim","onDestroy()호출..")
    }

}