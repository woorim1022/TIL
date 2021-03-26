package com.example.fragment.exam

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment.R

class ViewFragment3 : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("lifecycle","fragment::::onCeateView()")
        val view = inflater.inflate(R.layout.view3,container,false)
        return view
    }
}