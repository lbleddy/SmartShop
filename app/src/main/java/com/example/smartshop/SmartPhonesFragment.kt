package com.example.smartshop

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class SmartPhonesFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences  = this.requireActivity().getSharedPreferences(HomeScreen.EMAIL_KEY, Context.MODE_PRIVATE)
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_smart_phones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.lv_phones)
        recyclerView.adapter = OptionsAdapter(getOptionsData()){item ->
           // Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
            saveLoginDetails(item.name,item.price)

        }


    }
    private fun saveLoginDetails(email: String,price:Float) {
        Log.i("tag", "$email")
        val editor = sharedPreferences.edit()
        editor.putString(HomeScreen.EMAIL_KEY, email)
        editor.putFloat("price",price)
        editor.putInt("image_key",
            when(email){
                "Phone 1" -> R.drawable.baseline_phone1
                else -> {R.drawable.baseline_phone1}
            }
            )

        editor.commit()
        Log.i("tag", "after on Detach")

        when (email) {
            "Phone 1","Phone 2","Phone 3","Phone 4"
                ,"Phone 5","Phone 6","Phone 7","Phone 8",
                "Phone 9","Phone 10"
            -> {

                Log.i("tag", "here in phones1")
                activity?.run {
                    Log.i("tag","${sharedPreferences.getString(HomeScreen.EMAIL_KEY,"")}")
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ItemViewFragment()).commit()
                }
            }

            "Settings 2" ->
                activity?.run {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingsFragment2()).commit()
                }
        }
    }

    private fun getOptionsData():List<Option2>{
        return arrayListOf(
            Option2("Phone 1",R.drawable.baseline_phone_iphone_24,899.99f),
            Option2("Phone 2",R.drawable.baseline_phone_iphone_24,499.99f),
            Option2("Phone 4",R.drawable.baseline_phone_iphone_24,599.99f),
            Option2("Phone 5",R.drawable.baseline_phone_iphone_24,799.99f),
            Option2("Phone 6",R.drawable.baseline_phone_iphone_24,499.99f),
            Option2("Phone 7",R.drawable.baseline_phone_iphone_24,499.99f),
            Option2("Phone 8",R.drawable.baseline_phone_iphone_24,499.99f),
            Option2("Phone 9",R.drawable.baseline_phone_iphone_24,499.99f),
            Option2("Phone 10",R.drawable.baseline_phone_iphone_24,699.99f)


        )
    }
}