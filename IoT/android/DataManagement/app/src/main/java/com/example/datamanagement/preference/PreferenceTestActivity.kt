package com.example.datamanagement.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.shared_preference.*

//설정정보같이 앱이 종료되어도 계속 유지해야 하는 정보는 복잡하고 다른 데이터와 연관성이 있는 것들은 DB에 저장하고
//간단한 것들은 Preference 객체에 저장
class PreferenceTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shared_preference)
        //Preference객체를 추출
        //Preference객체에 저장하는 것은 name으로 구분하기 때문에 여러 개를 저장하는 것이 가능
        //Context.MODE_PRIVATE - 기존 데이터 유지하지 않고 덮어쓰기
        //Context.MODE_APPEND - 기존 데이터 위에 추가하기
        val mysetting = getSharedPreferences("network_conf", Context.MODE_PRIVATE)

        //Preference에 데이터를 저장하기 위한 객체 추출
        //SharedPreferences.Editor가 실제 데이터 저장하는 일을 담당하는 객체
        val editor: SharedPreferences.Editor = mysetting.edit()

        pref_write.setOnClickListener {
            //저장을 위한 메소드가 지원 - 타입별로 지원 putXXX
            //                                       ----
            //
            // 저장된 데이터를 가져오기 위한 메소드가 지원 - 타입별로 지원 getXXX
            //                                                        ----
            //                                                          데이터 타입
            editor.putBoolean("data1", true)
            editor.putInt("data2", 1000)
            editor.putString("data3", "문자열")
            editor.putFloat("data4", 100.5f)


            //문자열 셋트
            val mystrset = HashSet<String>()
            mystrset.add("C")
            mystrset.add("android")
            mystrset.add("kotlin")
            mystrset.add("arduino")
            mystrset.add("arduino")
            mystrset.add("android")
            mystrset.add("kotlin")
            editor.putStringSet("myset", mystrset)
            editor.commit()
            pref_txt.text = "preference에 저장 완료"
        }

        //Preference에 저장된 데이터 가져오기
        pref_read.setOnClickListener {
            var data = "${mysetting.getBoolean("data1",false)}" +
                    "${mysetting.getInt("data2",0)}" +
                    "${mysetting.getString("data3","")}" +
                    "${mysetting.getFloat("data4",0.0f)}"
            var myset = mysetting.getStringSet("myset", null)
            for (str in myset!!){
                data += "$str"
            }
            pref_txt.text = data
        }
    }

}
