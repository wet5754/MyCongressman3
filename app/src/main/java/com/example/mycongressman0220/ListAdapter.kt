package com.example.mycongressman0220

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(var items: ArrayList<Congressman>):RecyclerView.Adapter<ListAdapter.ViewHolder>(){
    lateinit var context:Context
    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var name = itemView.findViewById<TextView>(R.id.list_name)
        var district = itemView.findViewById<TextView>(R.id.list_district)
        var party = itemView.findViewById<TextView>(R.id.list_party)
        var party_logo = itemView.findViewById<TextView>(R.id.list_party_logo)
        var follow = itemView.findViewById<Button>(R.id.list_follow_button)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_cardview_layout, parent, false)
        context = this.context
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = items[position].이름
        holder.district.text = items[position].지역구
        holder.party.text = items[position].소속정당

        holder.follow.setOnClickListener {
            Toast.makeText(context,"팔로우됨",Toast.LENGTH_SHORT).show()
        }
        }
    }

