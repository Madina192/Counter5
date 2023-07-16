package com.example.counter5.view

interface MainActivityView {
    fun showNumber(number : Int)
    fun showToast(message : String)
    fun changeTextColor()
    fun changeThemeToDark()
    fun changeThemeToLight()
}