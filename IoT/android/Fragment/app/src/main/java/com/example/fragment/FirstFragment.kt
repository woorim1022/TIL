package com.example.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FirstFragment : Fragment(){

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("lifecycle","Fragment********************>>onAttach()호출..")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("lifecycle","Fragment********************>>onCreate()호출..")
    }

    //fragment가 뷰를 만들때 호출되는 메소드
    //액티비티에 배치될 때 호출된다. - 프레그먼트에 보여질 뷰를 그리기 위해서 호출하는 메소드
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("lifecycle","fragment::::onCeateView()")
        val view = inflater.inflate(R.layout.fragment_first2,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("lifecycle","Fragment********************>>onViewCreated()호출..")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("lifecycle","Fragment********************>>onActivityCreated()호출..")
    }

    override fun onStart() {
        super.onStart()
        Log.d("lifecycle","Fragment********************>>onStart()호출..")
    }

    override fun onResume() {
        super.onResume()
        Log.d("lifecycle","Fragment********************>>onResume()호출..")
    }

    override fun onPause() {
        super.onPause()
        Log.d("lifecycle","Fragment********************>>onPause()호출..")
    }

    override fun onStop() {
        super.onStop()
        Log.d("lifecycle","Fragment********************>>onStop()호출..")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle","Fragment********************>>onDestroy()호출..")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("lifecycle","Fragment********************>>onDestroyView()호출..")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("lifecycle","Fragment********************>>onDetach()호출..")
    }

}