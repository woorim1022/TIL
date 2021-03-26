package com.example.intent.exam

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast

import java.util.*

class ExamAdapter(context: Context,  var resId: Int,var  datalist: ArrayList<Person>)
            : ArrayAdapter<Person>(context, resId, datalist) {
    var userStateValue = HashMap<Int, MyMemento>()

    override fun getView(position: Int, convertView: View?,parent: ViewGroup): View {
        var rowView = convertView
        var holder : ViewHolder? = null
        if (rowView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            rowView = inflater.inflate(resId, null)
            holder =   ViewHolder(rowView)
            rowView.tag = holder

        }else {
            holder = rowView?.tag as ViewHolder
        }
        val actorItem = datalist[position]
        if (actorItem != null) {
            val myimg = holder.myimg
            val nameView = holder.nameView
            val dateView = holder.dateView
            val info = holder.info
            val chkVal = holder.chkVal

            myimg?.setImageResource(actorItem.myImg)
            nameView?.text = actorItem.name
            dateView?.text = actorItem.date
            info?.text = actorItem.info


	        //=======================미리설정되어 있는 체크값을 꺼내서 반영=================================
            //row를 구성하는 뷰를 만들면서 체크설정한 내용이 저장되어 있는지 확인하고 저장되어 있으면 저장된 값을
            // 체크박스에 셋팅하고 저장되어 있지않으면 체크박스에 체크되지 않은 상태로 설정
            //hashmap에서 꺼내기
            var saveObj = userStateValue[position]
            if(saveObj == null){
                chkVal?.isChecked = false
            }else{
                chkVal?.isChecked = saveObj.check
            }

            //onCheckedChangeListener에 처리하지 말아야 하는 이유는 이 이벤트는  checkbox 값이 변경되면 호출되므로
            //true에서 false로 변경되면 호출
            //==========================체크를 설정하면 설정한 값을 저장====================================
            chkVal?.setOnClickListener {
                val state = MyMemento()
                state.check = chkVal?.isChecked
                userStateValue[position] = state
                Toast.makeText(it.context,"체크박스가 선택됨",Toast.LENGTH_LONG).show()
            }

        }
        Log.d("setOnClickListener","총 저장갯수:${userStateValue.size}")
        return rowView!!
    }


}

