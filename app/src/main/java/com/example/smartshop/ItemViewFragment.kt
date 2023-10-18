package com.example.smartshop

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class ItemViewFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences  = this.requireActivity().getSharedPreferences(HomeScreen.EMAIL_KEY, Context.MODE_PRIVATE)

        sharedPreferences.getString("email_key","")?.let { Log.i("tag","the product name is $it") }
        initViews()
    }

    private fun initViews() {

        when(sharedPreferences.getString("email_key","")){
            "Phone 1"->{
                Log.i("tag","here in phone 1")
                var imageView = view?.findViewById<ImageView>(R.id.img_product)
        imageView?.setImageResource(R.drawable.baseline_phone1)}

    }}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_itemview, container, false)
    }


}