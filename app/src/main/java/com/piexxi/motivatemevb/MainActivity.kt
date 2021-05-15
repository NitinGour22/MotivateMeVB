package com.piexxi.motivatemevb

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.inputmethod.InputMethodManager
import com.piexxi.motivatemevb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListners()
        if(savedInstanceState != null)
        {
            binding.tvDisplayMsg.text = savedInstanceState.getString("message")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("message",binding.tvDisplayMsg.text.toString())
    }

    private fun initListners() {
        binding.btUpdate.setOnClickListener { updateMsg() }
    }

    private fun updateMsg() {
        val userName = binding.etName.text

        val motivationalMsg = listOf("Keep Working Hard..!", "Never Give Up..!", "Keep Your Head Up..!",
                "Difficulty is Growth", "Today is The First Day of Rest of Your Life")

        val index = (0..4).random()
        val currentMsg = motivationalMsg[index]

        if (userName.toString() == "") {
            binding.tvDisplayMsg.text = "Please make sue to Enter Your Name"
        } else {
            binding.tvDisplayMsg.text = "Hello $userName - $currentMsg"
        }

        binding.etName.setText("")

        hideKeyboard()
    }

    private fun hideKeyboard() {
       val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.etName.windowToken,0)
    }
}