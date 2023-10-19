package com.example.smartshop

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


/**
 * A simple [Fragment] subclass.
 * Use the [CartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CartFragment : Fragment() {
    companion object {
        var list: MutableList<Option2> = mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_cart)
        recyclerView.adapter = OptionsAdapter3(getCartData()) { item ->
            // Toast.makeText(this, "$item", Toast.LENGTH_SHORT).show()
        }
        val textView = view.findViewById<TextView>(R.id.priceTotalText)
        var totalPrice = 0f
        for(i in getCartData().indices){
            totalPrice += getCartData()[i].price
        }
        textView.text = "Total: ${totalPrice.toString()}"


}
     fun addCartItem(item:Option2){
        list.add(item)
    }
    private fun getCartData(): MutableList<Option2> {
        return list
    }

    }
