package com.example.smartshop

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import androidx.security.crypto.EncryptedSharedPreferences
import com.example.smartshop.databinding.ActivityFragmentContainerBinding

class FragmentContainer : AppCompatActivity() {
    private lateinit var communicator: Communicator
    private lateinit var binding: ActivityFragmentContainerBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentContainerBinding.inflate(layoutInflater)
       setContentView(binding.root)
        sharedPreferences = SecureSharedPref.getSharedPreferences(this.applicationContext)
        initViews()
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

    private fun initViews() {
        addNewFragment()
    }
    private fun addNewFragment() {
        Log.i("tag","here")
        when(sharedPreferences.getString("email_key","")) {
           "Smart Phones" -> supportFragmentManager.beginTransaction().add(R.id.container, SmartPhonesFragment())
                .commit()
            "Pool" -> supportFragmentManager.beginTransaction().add(R.id.container,PoolFragment())
        }
    }

}