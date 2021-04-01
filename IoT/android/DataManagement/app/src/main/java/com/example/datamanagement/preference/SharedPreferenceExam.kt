package com.example.datamanagement.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.datamanagement.R
import kotlinx.android.synthetic.main.setting.*

class SharedPreferenceExam : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.setting)

        val mysetting = getSharedPreferences("network_conf", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = mysetting.edit()

        Log.d("@@@",mysetting.getString("child","")!!)
        Log.d("@@@",mysetting.getString("nickname","")!!)
        Log.d("@@@",mysetting.getBoolean("alarm",false).toString())
        Log.d("@@@",mysetting.getBoolean("siren",false).toString())

        first_edit.setText(mysetting.getString("child",""))
        secod_edit.setText(mysetting.getString("nickname",""))
        check1.isChecked = mysetting.getBoolean("alarm",false)
        check2.isChecked = mysetting.getBoolean("siren",false)

        save.setOnClickListener {
            editor.putString("child", first_edit.text.toString())
            editor.putString("nickname", secod_edit.text.toString())
            editor.putBoolean("alarm", check1.isChecked)
            editor.putBoolean("siren", check2.isChecked)
            editor.commit()
        }


    }
}