package com.example.smartshop

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.smartshop.databinding.ActivityHomeScreenBinding


class HomeScreen : AppCompatActivity() {
    lateinit var communicator: Communicator
    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences  = SecureSharedPref.getSharedPreferences(this.applicationContext)
        initViews()
    }

    private fun initViews() {
        val recyclerView = findViewById<RecyclerView>(R.id.lv_options)
        val adapter = OptionsAdapter(getOptionsData())
        recyclerView.adapter=adapter


        recyclerView.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_UP)
                view.performClick()
            else
                false
        }

        recyclerView.setOnClickListener {
        val positionView = findViewById<RecyclerView>(R.id.lv_options).findContainingItemView(it)
        val currentName = positionView?.transitionName
             //var adapter = OptionsAdapter(getOptionsData())
                        //saveLoginDetails(currentName.toString())
            Log.i("tag","${currentName.toString()}")
                        //communicator.sendMessage ("${OptionsAdapter(getOptionsData()).getItem(position!!).name}")
                        startActivity (Intent(this, FragmentContainer::class.java))
            }
        }
    private fun saveLoginDetails(email: String) {
        val editor = sharedPreferences.edit()
        editor.putString(HomeScreen.EMAIL_KEY, email)

        //Validation for email, password
        //
        if(editor.commit()) {
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val SHARED_PREFERENCE_FILE_NAME = "login_details"
        const val EMAIL_KEY = "email_key"
        const val PASSWORD_KEY = "password_key"
    }










    private fun getOptionsData():List<Option>{
        return arrayListOf(
            Option("Settings",R.drawable.baseline_settings_24),
            Option("Browse",R.drawable.baseline_search_24),
            Option("Smart Phones",R.drawable.baseline_phone_iphone_24),
            Option("Laptops",R.drawable.baseline_computer_24),
            Option("Mens Wear",R.drawable.baseline_man_24),
            Option("Womens Wear",R.drawable.baseline_woman_24),
            Option("Outdoors",R.drawable.baseline_wb_sunny_24),
            Option("Pool",R.drawable.baseline_waves_24),
            Option("Winter",R.drawable.baseline_snowboarding_24)


        )
    }
}