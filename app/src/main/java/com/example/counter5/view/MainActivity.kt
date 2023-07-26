package com.example.counter5.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.example.counter5.viewModel.MainViewModel
import com.example.counter5.R
import com.example.counter5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showNumber()
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnIncrease.setOnClickListener {
                viewModel.increase()
            }
            btnDecrease.setOnClickListener {
                viewModel.decrease()
            }
            ivTheme.setOnClickListener {
                viewModel.changeBooleanState()
                changeTheme()
            }
        }
    }

    private fun showNumber() {
        viewModel.number.observe(this) {
            binding.tvNumber.text = it.toString()
            if (it == 10) {
                Toast.makeText(this, "Congratulations!", Toast.LENGTH_SHORT).show()
            } else if (it == 15) {
                binding.tvNumber.setTextColor(Color.parseColor("#33B538"))
            }
        }
    }

    private fun changeTheme() {
        viewModel.isDark.observe(this) {
            if (it) {
                binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                binding.ivTheme.setImageResource(R.drawable.ic_dark_theme)
                binding.tvNumber.setTextColor(Color.parseColor("#000000"))
            } else {
                binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                binding.ivTheme.setImageResource(R.drawable.ic_light_theme)
                binding.tvNumber.setTextColor(Color.parseColor("#ffffff"))
            }
        }
    }
}