package com.example.fragment.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.circle_item.view.*
import kotlinx.android.synthetic.main.simple_item.view.*

class CircleImageItemAdapter(var context: Context, var itemlayout:Int, var datalist:ArrayList<CircleItem>)
                                                            : RecyclerView.Adapter<CircleImageItemAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(itemlayout,null)
        val myViewHolder = MyViewHolder(itemView)
        return  myViewHolder
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var myCircleImg = holder.circleImg
        myCircleImg.setImageResource(datalist[position].img)

        myCircleImg.setOnClickListener{
            Toast.makeText(context,"이미지", Toast.LENGTH_LONG).show()
        }
    }
    override fun getItemCount(): Int {
        return datalist.size
    }
    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val circleImg = itemView.circleview
    }

}