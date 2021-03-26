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
//======================뷰를 재활용하고 row의 상태값들이 저장되도록 처리==================
//1. 뷰를 저장하기 위해서 한 row에 대한 뷰정보를 담고 있는 객체를 정의
//2. 데이터를 저장하기 위해서 사용자가 성정을 끝낸 시점 - focus 를 잃어버리는 시점에 데이터를 저장
// => 저장할 데이터를 담을 객체를 선언
class MyAdapter(context: Context, var resId:Int, var datalist:ArrayList<User>)
                                                :ArrayAdapter<User>(context, resId, datalist){
    //저장할 정보를 담고 있는 변수====================================
    var saveData = HashMap<Int, SaveUserState>()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val start = System.nanoTime()
        var row_view = convertView
        //재사용가능한 뷰가 있으면 뷰를 사용하고 없으면 뷰를 만들어준다.
        var holder:UserViewHolder? = null
        //최초로 작업하는 경우 row_view에 null이 전달되게 한다
        if(row_view==null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            row_view = inflater.inflate(resId, null)
            //=======뷰를 만드는 최초작업이므로 뷰를 가져오기 ==============
            holder = UserViewHolder(row_view)
            //위에서 만든 홀더를 저장
            row_view.tag = holder
        }else {//==========최초작업이 아닌 경우 뷰를 재사용중이라면==========
            //원래 뷰에 저장했던 홀더를 꺼내오기
            holder = row_view.tag as UserViewHolder
        }
        //데이터 연결하기
        val user = datalist[position]
        if(user!=null) {
            //위에서 홀더에 정의된 각 요소애 데이터 연결
            val imageView = holder.myImg
            val nameView = holder.nameView
            val telNumView = holder.telNumView
            val editView = holder.editView

            imageView?.setImageResource(user.myImg)
            nameView?.text = user.name
            telNumView?.text = user.telNum

            //SaveUserState에 저장된 값을 가져다 EditText에 출력하기
            //sate가 SaveUserState객체
            val state = saveData[position]
            if (state == null) {
                //한 번도 저장한 적이 없는 경우
                editView?.setText("")
            } else {
                editView?.setText(state.data)
            }

            //저장할 값이 있는 경우(EditText에 갑싱 입력된 경우)EditText에서 값을 입력하고 focus가 없어질 때
            //저장하기
            editView?.setOnFocusChangeListener { v, hasFocus ->
                if (!hasFocus) {
                    //포커스가 없엊디면 데이터 저장하기
                    val data = editView?.text.toString()//EditText에 입력한 데이터를 추출
                    val editState = SaveUserState()//추출한 데이터를 저장하기 위해 SaveUserState객체생성
                    editState.data = data//추출한 데이터를 SaveUserState객체의 data변수에 저장하기
                    saveData[position] = editState//HashMap에 값이 저장되어 있는 SaveUserState객체를
                    //position을 키로 해서 저장하기
                }
            }
        };
        val end = System.nanoTime()
        Log.d("getView", "getView()=========(실행시간:${end-start},position:${position})::::::::${row_view}")
        return row_view!!
    }

    override fun getItem(position: Int): User? {
        return super.getItem(position)
    }

    override fun getCount(): Int {
        return datalist.size
    }
}