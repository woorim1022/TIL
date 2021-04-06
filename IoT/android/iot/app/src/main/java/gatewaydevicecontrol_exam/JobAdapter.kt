package gatewaydevicecontrol_exam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.job_item.view.*

class JobAdapter(var context: Context, var itemlayout:Int, var joblist:ArrayList<Job>)
                                                            : RecyclerView.Adapter<JobAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(itemlayout,null)
        val myViewHolder = MyViewHolder(itemView)
        return  myViewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var date = holder.date
        var uid = holder.uid
        var ledstate = holder.ledstate
        date.text = joblist.get(position).date
        uid.text = joblist.get(position).id
        ledstate.text = joblist.get(position).ledstate
    }

    override fun getItemCount(): Int {
        return joblist.size
    }

    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val date = itemView.date
        val uid = itemView.uid
        val ledstate = itemView.ledstate
    }

}