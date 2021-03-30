package com.example.fragment.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragment.R

class FirstFragment_teacher : Fragment() {
    //프래그먼트가 액티비티에 Attach될 때 호출
    override fun onAttach(context: Context) {
        Log.d("lifecycle", "fragment========onAttach")
        super.onAttach(context)
    }
    //프레그먼트가 생성될때 호출된다.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("lifecycle", "fragment========onCreate")
    }
    //fragment뷰가 만들어질때 호출되는 메소드
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        Log.d("lifecycle", "Fragment:onCreateView()")
        val view =  inflater.inflate(R.layout.fragment_first2, container, false)
        return view
    }
    
    //프레그먼안의 뷰들이 모두 생성되면 호출되는 메소드
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("lifecycle", "fragment========onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }
    //액티비티에서 보여줄 프레그먼트가 완전히 생성되면 호출된다.
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("lifecycle", "fragment========onActivityCreated")
    }

    //프레그먼트가 가동될때
    override fun onStart() {
        super.onStart()
        Log.d("lifecycle", "fragment========onStart")
    }

    //프레그먼트가 보여지고 나서 호출
    override fun onResume() {
        super.onResume()
        Log.d("lifecycle", "fragment========onResume")
    }

    //프레그먼트가 일시정지될떄 프레그먼트를 다른 액티비티가 가리기 시작할때 호출
    override fun onPause() {
        super.onPause()
        Log.d("lifecycle", "fragment========onPause")
    }

    //프레그먼트가 화면에서 사라져서 완전히 보여지지 않을때(정지)완전히 덮어서 안 보일때
    override fun onStop() {
        super.onStop()
        Log.d("lifecycle", "fragment========onStop")
    }

    //프레그먼트에서 뷰를 지우기 - 프레그먼트가 제거될때
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("lifecycle", "fragment========onDestroyView")
    }

    //모두 지워지고 호출
    override fun onDestroy() {
        super.onDestroy()
        Log.d("lifecycle", "fragment========onDestroy")
    }

    //액티비티에서 프레그먼트가 교체될때
    override fun onDetach() {
        super.onDetach()
        Log.d("lifecycle", "fragment========onDetach")
    }
}