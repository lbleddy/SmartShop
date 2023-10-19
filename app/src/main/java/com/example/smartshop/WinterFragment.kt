package com.example.smartshop

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
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
        val dataList = getOptionsData()
        val recyclerView = view.findViewById<RecyclerView>(R.id.lv_phones)
        recyclerView.adapter = OptionsAdapter(getOptionsData()){item ->
            // Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
            saveLoginDetails(item.name)
        }
    }
    private fun saveLoginDetails(email: String) {
        Log.i("tag", "$email")
        val editor = sharedPreferences.edit()
        editor.putString(HomeScreen.EMAIL_KEY, email)
        editor.commit()

        editor.putInt("image_key",
            when(email){
                "Winter 1" -> R.drawable.baseline_snowboarding_24
                else -> {R.drawable.baseline_snowboarding_24}
            }
        )
        editor.commit()
        Log.i("tag", "after on Detach")

        when (email) {
            "Winter 1","Winter 2","Winter 3","Winter 4"
                ,"Winter 5","Winter 6","Winter 7","Winter 8",
            "Winter 9","Winter 10"
            -> {


                activity?.run {
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
            Option2("Winter 1",R.drawable.baseline_snowboarding_24,29.99f),
            Option2("Winter 2",R.drawable.baseline_snowboarding_24,199.99f),
            Option2("Winter 4",R.drawable.baseline_snowboarding_24,49.99f),
            Option2("Winter 5",R.drawable.baseline_snowboarding_24,399.99f),
            Option2("Winter 6",R.drawable.baseline_snowboarding_24,149.99f),
            Option2("Winter 7",R.drawable.baseline_snowboarding_24,29.99f),
            Option2("Winter 8",R.drawable.baseline_snowboarding_24,49.99f),
            Option2("Winter 9",R.drawable.baseline_snowboarding_24,9.99f),
            Option2("Winter 10",R.drawable.baseline_snowboarding_24,34.99f)


        )
    }
}