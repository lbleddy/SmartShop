package com.example.smartshop

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AbsListView.RecyclerListener
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class OptionsAdapter(val list: List<Option2>,private var onClickListener: (Option2) -> Unit) :
    RecyclerView.Adapter<OptionsAdapter.OptionViewHolder>(){




    class OptionViewHolder(val itemView:View): RecyclerView.ViewHolder(itemView) {
            val imageView: ImageView = itemView.findViewById<ImageView>(R.id.rv_photo)
            val textView: TextView = itemView.findViewById<TextView>(R.id.optionText)
            val textView2:TextView = itemView.findViewById<TextView>(R.id.priceText)
            val itemView1 = itemView

    }









    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
            return OptionsAdapter.OptionViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.custom_list_item_phone, parent, false)
            )
    }






    override fun getItemCount(): Int = list.size





    fun getItem(position: Int):Option2 {
        return list.get(position)
    }
    interface OnClickListener {
        fun onClick(position:Int,model:Option)
    }

    override fun onBindViewHolder(holder: OptionsAdapter.OptionViewHolder, position: Int) {
        holder.imageView.setImageResource(list.get(position).image)
        var item = list[position]
        holder.textView2.text = list.get(position).price.toString()
        holder.textView.text = list.get(position).name
        holder.itemView1.setOnClickListener{onClickListener(item)
        }


        }


        }








