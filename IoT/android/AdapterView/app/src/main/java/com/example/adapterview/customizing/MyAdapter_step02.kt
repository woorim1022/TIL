package com.example.adapterview.customizing

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.adapterview.R
import kotlinx.android.synthetic.main.custrow.view.*

//코틀린에서 지원하는 .run을 이용해서 xml import 기능을 이용해서 접근하기
class MyAdapter_step02(context: Context, var resId:Int, var datalist:ArrayList<User>)
                                                :ArrayAdapter<User>(context, resId, datalist){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val start = System.nanoTime()
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var row_view = convertView
        row_view = inflater.inflate(resId, null)

        val user = datalist[position]

        row_view.run{  //xml import가 가능하도록 한다.
            myimg.setImageResource(user.myImg)
            txtcust1.text = user.name
            txtcust2.text = user.telNum
        }

        val end = System.nanoTime()
        Log.d("getView", "getView()=========(실행시간:${end-start},${position})")
        return row_view
    }

    //매개변수로 전달받은 순서에 있는 리스트 한 항목을 반환
    override fun getItem(position: Int): User? {
        return super.getItem(position)
    }

    //리스트갯수를 반환하는 메소드
    override fun getCount(): Int {
        return datalist.size
    }
}