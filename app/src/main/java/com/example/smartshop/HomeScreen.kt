package com.example.smartshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class HomeScreen : AppCompatActivity() {
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        val recyclerView = findViewById<RecyclerView>(R.id.lv_options)
        val adapter = OptionsAdapter(getOptionsData())
        recyclerView.adapter= adapter
    }

    private fun getOptionsData():List<Option>{
        return arrayListOf(
            Option("Settings",R.drawable.baseline_settings_24),
            Option("Browse",0),
            Option("Smart Phones",R.drawable.baseline_phone_iphone_24),
            Option("Laptops",0),
            Option("Mens Wear",0),
            Option("Womens Wear",0),
            Option("Outdoors",0),
            Option("Pool",0),
            Option("Winter",0),
            Option("Summer",0)


        )
    }
}