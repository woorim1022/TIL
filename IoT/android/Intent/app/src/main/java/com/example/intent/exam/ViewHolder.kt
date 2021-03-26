package com.example.intent.exam

import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.example.intent.R

class ViewHolder {
    var myimg: ImageView? = null
    var nameView: TextView? = null
    var dateView: TextView? = null
    var info: TextView? = null
    var chkVal: CheckBox? = null

    constructor(parentView: View) {
        myimg = parentView.findViewById(R.id.myImg)
        nameView = parentView.findViewById(R.id.name)
        dateView = parentView.findViewById(R.id.date)
        info = parentView.findViewById(R.id.resultinfo)
        chkVal = parentView.findViewById(R.id.exam_chk)
    }
}