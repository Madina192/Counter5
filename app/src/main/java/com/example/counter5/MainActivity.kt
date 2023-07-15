package com.example.counter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.counter5.databinding.ActivityMainBinding
import com.example.counter5.view.CounterView

class MainActivity : AppCompatActivity(), CounterView {
    private lateinit var binding: ActivityMainBinding
    private val presenter = Injector.getPesenter(this)
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnIncrease.setOnClickListener{
                presenter.increase()
            }
            btnDecrease.setOnClickListener{
                presenter.decrease()
            }
        }
    }

    override fun showNumber(number : Int) {
        binding.tvNumber.text = number.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun changeThemeToDark() {
        binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
    }

    override fun changeThemeToLight() {
        binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
    }
}