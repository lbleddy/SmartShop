package com.example.smartshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PoolFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WinterFragment : Fragment() {

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
        recyclerView.adapter = OptionsAdapter(getOptionsData()){item ->
            // Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getOptionsData():List<Option>{
        return arrayListOf(
            Option("Winter 1",R.drawable.baseline_snowboarding_24),
            Option("Winter 2",R.drawable.baseline_snowboarding_24),
            Option("Winter 4",R.drawable.baseline_snowboarding_24),
            Option("Winter 5",R.drawable.baseline_snowboarding_24),
            Option("Winter 6",R.drawable.baseline_snowboarding_24),
            Option("Winter 7",R.drawable.baseline_snowboarding_24),
            Option("Winter 8",R.drawable.baseline_snowboarding_24),
            Option("Winter 9",R.drawable.baseline_snowboarding_24),
            Option("Winter 10",R.drawable.baseline_snowboarding_24)


        )
    }
}