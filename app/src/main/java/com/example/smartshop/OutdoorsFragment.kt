package com.example.smartshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [OutdoorsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OutdoorsFragment : Fragment() {

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
            Option("Outdoors 1", R.drawable.baseline_wb_sunny_24),
            Option("Outdoors 2", R.drawable.baseline_wb_sunny_24),
            Option("Outdoors 4", R.drawable.baseline_wb_sunny_24),
            Option("Outdoors 5", R.drawable.baseline_wb_sunny_24),
            Option("Outdoors 6", R.drawable.baseline_wb_sunny_24),
            Option("Outdoors 7", R.drawable.baseline_wb_sunny_24),
            Option("Outdoors 8", R.drawable.baseline_wb_sunny_24),
            Option("Outdoors 9", R.drawable.baseline_wb_sunny_24),
            Option("Outdoors 10", R.drawable.baseline_wb_sunny_24)


        )
    }
}