package com.example.counter5.model

class MainActivityModel {
    var number = 0
    var isDark = false

    fun increase() {
        number++
    }

    fun decrease() {
        if (number > 0) {
            number--
        }
    }
}