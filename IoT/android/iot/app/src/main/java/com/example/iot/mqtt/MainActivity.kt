package com.example.iot.mqtt

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.datamanagement.sqlite.MyTableDB
import com.example.iot.R
import com.example.iot.mqtt.notification.SubActivity
import com.example.iot.mqtt.sensor.DetectionActivity
import gatewaydevicecontrol_exam.Job
import gatewaydevicecontrol_exam.JobAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.eclipse.paho.client.mqttv3.MqttMessage
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
        mqttClient = MyMqtt(this,"tcp://192.168.0.197:1883")
        try{
            mqttClient.setCallback(::onReceived)
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
        var myjob = Job(SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.KOREA).format(currentDateTime).toString(), showdata.text.toString(),ledstate)
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

    fun onReceived(topic:String,message:MqttMessage){
        //토픽에 대한 수신처리
        val msg = String(message.payload)
        if(msg.equals("motion detect")){
            //노티띄우기
            val bitmap = BitmapFactory.decodeResource(resources,R.drawable.lee)
            var builder = NotificationCompat.Builder(this,"1111")
                .setSmallIcon(android.R.drawable.ic_notification_overlay)
                .setContentTitle("연습")
                .setContentText("노티피케이션 연습")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setLargeIcon(bitmap)
                .setDefaults(
                    Notification.DEFAULT_SOUND or Notification.DEFAULT_VIBRATE or
                            Notification.DEFAULT_LIGHTS)
            val style = NotificationCompat.BigPictureStyle(builder)
            style.bigPicture(bitmap)
            builder.setStyle(style)
            val myintent = Intent(this, DetectionActivity::class.java)
            val mypendingIntent = PendingIntent.getActivity(this, 10,myintent,
                PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(mypendingIntent)
            createNotiChannel(builder,"1111")
            showdata.append("침입자발생!!-----------${Date().toString()}\n")
        }
        Log.d("mymqtt",msg)
    }

    //notification 실행
    fun createNotiChannel(builder: NotificationCompat.Builder, id:String){
        //낮은 버전의 사용자에 대한 설정
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel =
                NotificationChannel(id,"mynetworkchannel", NotificationManager.IMPORTANCE_HIGH)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
            notificationManager.notify(Integer.parseInt(id),builder.build())
        }else{
            //이전버전인 경우
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(Integer.parseInt(id),builder.build())
        }
    }

}