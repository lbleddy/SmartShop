package com.example.smartshop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhonesAdapter
   (val list: List<Option>) :
        RecyclerView.Adapter<PhonesAdapter.PhoneViewHolder>(){


        class PhoneViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById<ImageView>(R.id.rv_photo)
            val textView: TextView = itemView.findViewById<TextView>(R.id.optionText)



        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
            return PhoneViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.custom_list_item_phone, parent, false)
            )}




    override fun getItemCount(): Int = list.size



        override fun onBindViewHolder(holder: PhonesAdapter.PhoneViewHolder, position: Int) {
            holder.imageView.setImageResource(list.get(position).image)
            holder.textView.text = list.get(position).name


        }



    }

