package com.example.iot.mqtt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datamanagement.sqlite.MyTableDB
import com.example.iot.R
import gatewaydevicecontrol_exam.Job
import gatewaydevicecontrol_exam.JobAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var mqttClient:MyMqtt
    var dao: MyTableDB? = null
    var joblist = ArrayList<Job>()
    val currentDateTime = Calendar.getInstance().time


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mqttClient = MyMqtt(this,"tcp://192.168.35.177:1883")
        try{
            mqttClient.connect(arrayOf<String>("iot/#"))
        }
        catch (e:Exception){
            e.printStackTrace()
        }
        btn_led_on.setOnClickListener(this)
        btn_led_off.setOnClickListener(this)

        dao = MyTableDB(this)

        select()
        for(i in joblist){
            Log.d("@@@@", "\n날짜:${i.date}\n아이디:${i.id} \n" +
                    "led상태:${i.ledstate} \n=================\n")
        }
        val myadapter = JobAdapter(this,R.layout.job_item,joblist)
        val manager = LinearLayoutManager(this)
        myrecycler1.layoutManager = manager//setter메소드 호출
        myrecycler1.adapter = myadapter
    }

    override fun onClick(v: View?) {
        var data:String = ""
        if(v?.id==R.id.btn_led_on){
            //데이터베이스에 insert
            insert("on")
            data="led_on"
        }else{
            //데이터베이스에 insert
            insert("off")
            data="led_off"
        }
        publish(data)
    }


    fun insert(ledstate:String){
        var myjob = Job(SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA).format(currentDateTime).toString(), id.text.toString(),ledstate)

        dao?.insert(myjob)
        Toast.makeText(this, "삽입성공", Toast.LENGTH_LONG).show()
    }

    fun select(){
        val result:ArrayList<Job> ?= dao?.select()
        if (result != null) {
            for(i in result){
                joblist.add(i)
            }
        }
    }

    fun publish(data:String){
        ///mqttClient의 publish기능의 메소드를 호출
        mqttClient.publish("mydata/led",data)
    }


}