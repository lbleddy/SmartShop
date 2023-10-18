package com.example.smartshop

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.example.smartshop.databinding.ActivityFragmentContainerBinding

class FragmentContainer : AppCompatActivity(),Communicator {
    private lateinit var communicator: Communicator

    private lateinit var binding: ActivityFragmentContainerBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("tag","here in onCreate")

            binding = ActivityFragmentContainerBinding.inflate(layoutInflater)
            setContentView(binding.root)
            sharedPreferences = SecureSharedPref.getSharedPreferences(this.applicationContext)
            initViews()

    }

    override fun sendMessage() {
        Log.i("tag","here in sendMessage")
        sharedPreferences  = SecureSharedPref.getSharedPreferences(this.applicationContext)
        addNewFragment()
    }
    fun onCreate2(){
        Log.i("tag","onCreate")

        //sharedPreferences = SecureSharedPref.getSharedPreferences(this.applicationContext)
        supportFragmentManager.beginTransaction().remove(SettingsFragment()).commitAllowingStateLoss()

        //setContentView(R.layout.activity_fragment_container)
        initViews()
    }



    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    private fun getOptionsData(): List<Option> {
        return arrayListOf(
            Option("Settings", R.drawable.baseline_settings_24),
            Option("Browse", R.drawable.baseline_search_24),
            Option("Smart Phones", R.drawable.baseline_phone_iphone_24),
            Option("Laptops", R.drawable.baseline_computer_24),
            Option("Mens Wear", R.drawable.baseline_man_24),
            Option("Womens Wear", R.drawable.baseline_woman_24),
            Option("Outdoors", R.drawable.baseline_wb_sunny_24),
            Option("Pool", R.drawable.baseline_waves_24),
            Option("Winter", R.drawable.baseline_snowboarding_24)


        )
    }

    fun initViews() {

        addNewFragment()
    }

    private fun addNewFragment() {
        Log.i("tag", "here")
        Log.i("tag","${sharedPreferences.getString("email_key","")}")
        when (sharedPreferences.getString("email_key", "")) {
            "Smart Phones" -> supportFragmentManager.beginTransaction()
                .add(R.id.container, SmartPhonesFragment())
                .commit()

            "Pool" -> {
                Log.i("tag", "here in pool")
                supportFragmentManager.beginTransaction().add(
                    R.id.container,
                    PoolFragment()
                ).commit()
            }

            "Winter" -> {
                supportFragmentManager.beginTransaction().add(
                    R.id.container, WinterFragment()
                ).commit()

            }
            "Laptops" -> {
                supportFragmentManager.beginTransaction().add(R.id.container,LaptopsFragment()).commit()
            }
            "Settings" -> {
                supportFragmentManager.beginTransaction().add(R.id.container,SettingsFragment()).commit()
            }
            "Outdoors" -> {
                supportFragmentManager.beginTransaction().add(R.id.container,OutdoorsFragment()).commit()
            }
            "Browse" -> {
                supportFragmentManager.beginTransaction().add(R.id.container,BrowseFragment()).commit()
            }
            "Settings 1" ->{
                Log.i("tag","here in settings1")
                supportFragmentManager.beginTransaction().add(R.id.container,SettingsFragment1()).commit()
            }
        }

    }


}
