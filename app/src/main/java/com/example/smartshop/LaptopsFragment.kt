package com.example.smartshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [LaptopsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LaptopsFragment : Fragment() {

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
        recyclerView.adapter = OptionsAdapter(getOptionsData()) { item ->
            // Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getOptionsData():List<Option>{
        return arrayListOf(
            Option("Laptop 1", R.drawable.baseline_computer_24),
            Option("Laptop 2", R.drawable.baseline_computer_24),
            Option("Laptop 4", R.drawable.baseline_computer_24),
            Option("Laptop 5", R.drawable.baseline_computer_24),
            Option("Laptop 6", R.drawable.baseline_computer_24),
            Option("Laptop 7", R.drawable.baseline_computer_24),
            Option("Laptop 8", R.drawable.baseline_computer_24),
            Option("Laptop 9", R.drawable.baseline_computer_24),
            Option("Laptop 10", R.drawable.baseline_computer_24)


        )
    }
}