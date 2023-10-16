package com.example.smartshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class SmartPhonesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        val dataList = getOptionsData()
        val recyclerView = view.findViewById<RecyclerView>(R.id.lv_phones)
        val adapter = OptionsAdapter(dataList)
        recyclerView.adapter=adapter
    }

    private fun getOptionsData():List<Option>{
        return arrayListOf(
            Option("Phone 1",R.drawable.baseline_phone_iphone_24),
            Option("Phone 2",R.drawable.baseline_phone_iphone_24),
            Option("Phone 4",R.drawable.baseline_phone_iphone_24),
            Option("Phone 5",R.drawable.baseline_phone_iphone_24),
            Option("Phone 6",R.drawable.baseline_phone_iphone_24),
            Option("Phone 7",R.drawable.baseline_phone_iphone_24),
            Option("Phone 8",R.drawable.baseline_phone_iphone_24),
            Option("Phone 9",R.drawable.baseline_phone_iphone_24),
            Option("Phone 10",R.drawable.baseline_phone_iphone_24)


        )
    }
}