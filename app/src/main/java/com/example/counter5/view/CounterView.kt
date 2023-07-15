package com.example.counter5.view

interface CounterView {
    fun showNumber(number : Int)
    fun showToast(message : String)
    fun changeThemeToDark()
    fun changeThemeToLight()
}