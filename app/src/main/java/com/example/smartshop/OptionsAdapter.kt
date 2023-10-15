package com.example.smartshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OptionsAdapter(val list: List<Option>) :
    RecyclerView.Adapter<OptionsAdapter.OptionViewHolder>(){
        class OptionViewHolder(val itemView:View): RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById<ImageView>(R.id.rv_photo)
            val textView: TextView = itemView.findViewById<TextView>(R.id.optionText)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
            return OptionViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.custom_list_item, parent, false)
            )
    }

    override fun getItemCount(): Int = list.size



    override fun onBindViewHolder(holder: OptionsAdapter.OptionViewHolder, position: Int) {
        holder.imageView.setImageResource(list.get(position).image)
        holder.textView.text = list.get(position).name
    }
}
