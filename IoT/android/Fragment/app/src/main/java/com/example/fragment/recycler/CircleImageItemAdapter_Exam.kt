package com.example.fragment.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_item_exam.view.*

class CircleImageItemAdapter_Exam(var context: Context, var itemlayout:Int, var datalist:ArrayList<CircleItem_Exam>)
                                                            : RecyclerView.Adapter<CircleImageItemAdapter_Exam.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(itemlayout,null)
        val myViewHolder = MyViewHolder(itemView)
        return  myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var myimgView = holder.img_exam
        myimgView.setImageResource(datalist[position].img)
        myimgView.setOnClickListener{
            Toast.makeText(context,"이미지", Toast.LENGTH_LONG).show()
        }
        var myTextView = holder.text_exam
        myTextView.text = datalist.get(position).title
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val img_exam = itemView.img_exam
        val text_exam = itemView.text_exam
    }

}