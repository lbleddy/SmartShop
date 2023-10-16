package com.example.smartshop

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView.RecyclerListener
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class OptionsAdapter(val list: List<Option>) :
    RecyclerView.Adapter<OptionsAdapter.OptionViewHolder>(){





    class OptionViewHolder(val itemView:View): RecyclerView.ViewHolder(itemView),View.OnClickListener {
            val imageView: ImageView = itemView.findViewById<ImageView>(R.id.rv_photo)
            val textView: TextView = itemView.findViewById<TextView>(R.id.optionText)
        override fun onClick(v: View?) {

        }
    }









    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
            return OptionsAdapter.OptionViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.custom_list_item, parent, false)
            )
    }






    override fun getItemCount(): Int = list.size





    fun getItem(position: Int):Option {
        return list.get(position)
    }


    override fun onBindViewHolder(holder: OptionsAdapter.OptionViewHolder, position: Int) {
        holder.imageView.setImageResource(list.get(position).image)
        holder.textView.text = list.get(position).name



        }





}

