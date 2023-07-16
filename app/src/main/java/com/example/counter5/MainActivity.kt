package com.example.counter5

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.counter5.databinding.ActivityMainBinding
import com.example.counter5.view.MainActivityView

class MainActivity : AppCompatActivity(), MainActivityView {
    private lateinit var binding: ActivityMainBinding
    private val presenter = Injector.getPresenter(this)

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
            ivTheme.setOnClickListener{
                presenter.changeTheme()
            }
        }
    }

    override fun showNumber(number : Int) {
        binding.tvNumber.text = number.toString()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("ResourceAsColor")
    override fun changeTextColor() {
        binding.tvNumber.setTextColor(Color.parseColor("#33B538"))
    }

    override fun changeThemeToDark() {
        binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        binding.ivTheme.setImageResource(R.drawable.ic_light_theme)
        binding.tvNumber.setTextColor(Color.parseColor("#ffffff"))
    }

    override fun changeThemeToLight() {
        binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        binding.ivTheme.setImageResource(R.drawable.ic_dark_theme)
        binding.tvNumber.setTextColor(Color.parseColor("#000000"))
    }
}