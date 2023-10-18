package com.example.smartshop


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LaptopsFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var communicator: Communicator

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator = context as Communicator
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences =
            this.requireActivity().getSharedPreferences(HomeScreen.EMAIL_KEY, Context.MODE_PRIVATE)

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
            saveLoginDetails(item.name)
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

    private fun saveLoginDetails(email: String) {
        Log.i("tag", "$email")
        val editor = sharedPreferences.edit()
        editor.putString(HomeScreen.EMAIL_KEY, email)
        Log.i("tag", "after on Detach")

        when (email) {
            "Laptop 1" -> {
               Log.i("tag","here in laptop1")
                activity?.run {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, LaptopsFragment1()).commit()
                }
            }

            "Pool 2" ->
                activity?.run {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingsFragment2()).commit()
                }
        }
    }
}

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

