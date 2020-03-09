package com.example.mycongressman0220.Tab1

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycongressman0220.DataClass.Bill
import com.example.mycongressman0220.R
import com.example.mycongressman0220.Tab1.Tab1Adapter.ViewHolder

class Tab1Adapter(var context: Context, var items: ArrayList<Bill>):RecyclerView.Adapter<ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var pic = itemView.findViewById<ImageView>(R.id.tab1_card_pic)
        var name = itemView.findViewById<TextView>(R.id.tab1_card_name)
        var date = itemView.findViewById<TextView>(R.id.tab1_card_date)
        var title = itemView.findViewById<TextView>(R.id.tab1_card_title)
        var content = itemView.findViewById<TextView>(R.id.tab1_card_content)
        var more = itemView.findViewById<Button>(R.id.tab1_card_more)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.tab1_card_layout, parent, false)
        Log.d("tab1","viewholder made")
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.date.setText(item.date)
        holder.title.setText(item.title)
        holder.content.setText(item.content)
        holder.more.setOnClickListener {
            //TODO
        }
        Log.d("recycleriew","successful")
    }



}