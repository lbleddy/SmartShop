package com.example.smartshop

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.smartshop.databinding.ActivityHomeScreenBinding
import com.example.smartshop.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initSharedPreferences()
        initViews()
    }

    private fun initViews() {
        binding.btnSignIn.setOnClickListener {
            val email = binding.edEmail.text.toString()
            val password = binding.edPassword.text.toString()

            saveLoginDetails(email,password)
            startActivity(Intent(this,HomeScreen::class.java))
        }

    }

    private fun initSharedPreferences() {
        sharedPreferences = SecureSharedPref.getSharedPreferences(this.applicationContext)
    }

    private fun saveLoginDetails(email: String, pass: String) {
        val editor = sharedPreferences.edit()
        editor.putString(LoginActivity.EMAIL_KEY, email)
        editor.putString(LoginActivity.PASSWORD_KEY, pass)
        //Validation for email, password
        //
        if(editor.commit()) {
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val SHARED_PREFERENCE_FILE_NAME = "login_details"
        const val EMAIL_KEY = "email_key"
        const val PASSWORD_KEY = "password_key"
    }

}