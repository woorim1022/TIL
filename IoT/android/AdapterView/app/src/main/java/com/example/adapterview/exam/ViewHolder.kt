package com.example.adapterview.exam

import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.example.adapterview.R

class ViewHolder {
    var myimg: ImageView? = null
    var nameView: TextView? = null
    var dateView: TextView? = null
    var info: TextView? = null
    var chkVal: CheckBox? = null

    constructor(parentView: View) {
    }
}