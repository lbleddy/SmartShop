package com.example.smartshop

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.os.persistableBundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [Outdoors1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Outdoors1Fragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var communicator: Communicator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator=context as Communicator
    }
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
        recyclerView.adapter = OptionsAdapter(getOptionsData()) { item ->
            // Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
            saveLoginDetails(item.name,item.price)
        }

    }


    private fun getOptionsData():List<Option2>{
        return arrayListOf(
            Option2("Outdoors 1", R.drawable.baseline_wb_sunny_24,149.99f),
            Option2("Outdoors 2", R.drawable.baseline_wb_sunny_24,49.99f),
            Option2("Outdoors 4", R.drawable.baseline_wb_sunny_24,19.99f),
            Option2("Outdoors 5", R.drawable.baseline_wb_sunny_24,24.99f),
            Option2("Outdoors 6", R.drawable.baseline_wb_sunny_24,29.99f),
            Option2("Outdoors 7", R.drawable.baseline_wb_sunny_24,4.99f),
            Option2("Outdoors 8", R.drawable.baseline_wb_sunny_24,5.99f),
            Option2("Outdoors 9", R.drawable.baseline_wb_sunny_24,149.99f),
            Option2("Outdoors 10", R.drawable.baseline_wb_sunny_24,59.99f)


        )
    }

    private fun saveLoginDetails(email: String,price:Float) {
        Log.i("tag","$email")
        val editor = sharedPreferences.edit()
        editor.putString(HomeScreen.EMAIL_KEY, email)
        editor.putFloat("price",price)
        editor.putInt("image_key",when(email){
            "Outdoors 1" -> R.drawable.baseline_wb_sunny_24
            else->{R.drawable.baseline_wb_sunny_24}
        })
        editor.commit()
        Log.i("tag","after on Detach")


            activity?.run {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ItemViewFragment()).commit()
            }}


//        activity?.run{
//            if(supportFragmentManager.backStackEntryCount ==0){
//
//
//                this.finish()
//                communicator.sendMessage()
//                Log.i("tag","here after finish")
//            }
//            else{
//                supportFragmentManager.popBackStack()
//            }
           // FragmentContainer().onCreate2()
            //supportFragmentManager.beginTransaction().remove(SettingsFragment()).commitAllowingStateLoss()

        //Validation for email, password
        //



}