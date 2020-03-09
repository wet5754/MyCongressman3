package com.example.mycongressman0220

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycongressman0220.DataClass.Congressman

class CongressmanAdapter(var items: ArrayList<Congressman>):RecyclerView.Adapter<CongressmanAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var name = itemView.findViewById<TextView>(R.id.list_name)
        var district = itemView.findViewById<TextView>(R.id.list_district)
        var party = itemView.findViewById<TextView>(R.id.list_party)
        var party_logo = itemView.findViewById<ImageView>(R.id.list_party_logo)
        var follow = itemView.findViewById<Button>(R.id.list_follow_button)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.congressman_card_layout, parent, false)
        Log.d("adapter","viewholder made")
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.name.setText(item.이름)
        holder.district.setText(item.지역구)
        holder.party.setText(item.소속정당)
//        holder.itemView.setOnClickListener {
//
//        }
    }
}

