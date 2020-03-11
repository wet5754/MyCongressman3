package com.example.mycongressman0220

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycongressman0220.DataClass.Bill

class Tab1Adapter(var items:ArrayList<Bill>): RecyclerView.Adapter<Tab1Adapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var pic = itemView.findViewById<ImageView>(R.id.tab1_card_pic)
        var name = itemView.findViewById<TextView>(R.id.tab1_card_name)
        var date = itemView.findViewById<TextView>(R.id.tab1_card_date)
        var title = itemView.findViewById<TextView>(R.id.tab1_card_title)
        var content = itemView.findViewById<TextView>(R.id.tab1_card_content)
        var more = itemView.findViewById<ImageButton>(R.id.tab1_card_more)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.tab1_card_layout, parent, false)
        Log.d("tab1", "viewholder made")
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = items.get(position)
        holder.date.setText(item.date)
        holder.title.setText(item.title)
        holder.content.setText(item.content)

//        var tab1Fragment = Tab1Fragment()
//        var bundle = Bundle()
//        bundle.putParcelable(item)
//
//
//        Log.d("recycleriew","successful")
    }
    override fun getItemCount(): Int {
        return items.size
    }
}



