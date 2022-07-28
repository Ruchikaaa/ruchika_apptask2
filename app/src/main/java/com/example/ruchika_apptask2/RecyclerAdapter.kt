package com.example.ruchika_apptask2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(val Valorant: Valomodel):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    lateinit var context:Context
    class ViewHolder(val view:View):RecyclerView.ViewHolder(view){
        var agents:TextView = view.findViewById(R.id.valotext)
        var img:ImageView = view.findViewById(R.id.valoImg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.agents.text = Valorant{position}.name
        Glide.with(context).load(Valorant{position}.image?.url).into(holder.img)
        holder.img.setOnLongClickListener {
            context.startActivities(Intent(Context, ValoInfo::class.java).apply {
                putExtra("img",Valorant{position}.image?.url)
                putExtra("ValoInfo",valorant{position})
            })
        }
    }

    override fun getItemCount(): Int {
        return Valorant.size
    }
}