package com.example.adapterview.exam

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.Toast
import com.example.adapterview.R
import kotlinx.android.synthetic.main.select_exam.*
import java.util.*

class SelectView_ExamActivity : Activity() {
    var actorlist= ArrayList<Person>()
    var currentView:ViewHolder?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.select_exam)
        var actorItem: Person
        actorItem = Person(R.drawable.ansoccer, "안정환", "2021/04/06", "멋져")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.chasoccer, "차범근", "2021/04/06", "아들~~")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.jjangkim, "김어준", "2021/04/06", "찐")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.kbr, "김범룡", "2021/04/06", "진짜가수")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.kimdong, "이민호", "2021/04/06", "멋져")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.kimdong, "이민호", "2021/04/06", "멋져")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.kimdong, "박지성", "2021/04/06", "멋져")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.ansoccer, "안정환", "2021/04/06", "멋져")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.chasoccer, "차범근", "2021/04/06", "아들~~")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.jjangkim, "김어준", "2021/04/06", "찐")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.kbr, "김범룡", "2021/04/06", "진짜가수")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.kimdong, "이민호", "2021/04/06", "멋져")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.kimdong, "이민호", "2021/04/06", "멋져")
        actorlist.add(actorItem)
        actorItem = Person(R.drawable.kimdong, "박지성", "2021/04/06", "멋져")
        actorlist.add(actorItem)

        val adapter = ExamAdapter(this, R.layout.select_exam_row, actorlist)
        exam_listView.adapter = adapter

        Toast.makeText(this,"문자열", Toast.LENGTH_LONG).show()

        var mylistener = AdapterView.OnItemClickListener{parent, view, position, id ->
            Log.d("test","test")
            var listIntent = Intent(this@SelectView_ExamActivity,ListItemDetailActivity::class.java)
            var myobj = PersonValue()
            myobj.myImg = actorlist[position].myImg
            myobj.name = actorlist[position].name
            myobj.info = actorlist[position].info
            myobj.date = actorlist[position].date

            listIntent.putExtra("myobj",myobj)
            currentView = view.getTag() as ViewHolder
            startActivityForResult(listIntent, 100)

        }
        exam_listView.onItemClickListener = mylistener
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==100){
            if(resultCode==111){
                var myobj = data?.getParcelableExtra<PersonValue>("myobj")
                val check = data?.getBooleanExtra("check",false)
                currentView?.chkVal?.isChecked = check!!
                currentView?.nameView?.text = myobj?.name
                currentView?.dateView?.text = myobj?.date
                currentView?.info?.text = myobj?.info
                //데이터를 DB나 파일에서 가져왔을 때 데이터로 DB나 파일의 내용까지 변경하는 코드 추가해야 함
            }
        }
    }
}
