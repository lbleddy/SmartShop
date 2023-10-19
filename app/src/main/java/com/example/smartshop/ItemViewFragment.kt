package com.example.smartshop

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.core.net.toUri


class ItemViewFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences  = this.requireActivity().getSharedPreferences(HomeScreen.EMAIL_KEY, Context.MODE_PRIVATE)

        sharedPreferences.getString("email_key","")?.let { Log.i("tag","the product name is $it") }
        sharedPreferences.getFloat("price",0f)?.let { Log.i("tag","the product price is $it") }
    }

    private fun initViews() {
        var imageView = view?.findViewById<ImageView>(R.id.img_product)
        var textView = view?.findViewById<TextView>(R.id.productTitle)
        textView?.text = sharedPreferences.getString("email_key","")
        imageView?.setImageResource(sharedPreferences.getInt("image_key",0))
        view?.findViewById<TextView>(R.id.priceText)?.text   = sharedPreferences.getFloat("price",0f).toString()
        view?.findViewById<Button>(R.id.btnAddtoCart)?.setOnClickListener {
           addtoCart(Option2(textView?.text.toString(),sharedPreferences.getInt("image_key",0),sharedPreferences.getFloat("price",0f)))
        }
        view?.findViewById<ImageView>(R.id.btnCart)?.setOnClickListener {
            activity?.run {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, CartFragment()).commit()
            }}
        }




    private fun addtoCart(item:Option2) {
        val editor = sharedPreferences.edit()
        editor.putString("cartProductName", item.name)
        editor.putInt("image_key", sharedPreferences.getInt("image_key", 0))
        editor.putFloat("price", sharedPreferences.getFloat("price", 0f))
        if (editor.commit()) {
            Toast.makeText(activity, "Saved", Toast.LENGTH_SHORT).show()
        }
        addItemtoCart(item)

    }

    private fun addItemtoCart(item:Option2) {
        var cartFragment = CartFragment()
        cartFragment.addCartItem(item)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_itemview, container, false)
    }

    override fun onResume() {
        super.onResume()
        sharedPreferences = this.requireActivity().getSharedPreferences(HomeScreen.EMAIL_KEY,Context.MODE_PRIVATE)
        initViews()
    }


}