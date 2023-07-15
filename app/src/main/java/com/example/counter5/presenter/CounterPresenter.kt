package com.example.counter5.presenter

import com.example.counter5.Injector
import com.example.counter5.view.CounterView

class CounterPresenter constructor(var view: CounterView) {
    private val model = Injector.getModel()

    fun increase() {
        model.increase()
        view.showNumber(model.number)
        showToastIfAboveTen()
    }
    fun decrease() {
        model.decrease()
        view.showNumber(model.number)
        showToastIfAboveTen()
    }

    private fun showToastIfAboveTen() {
        if(model.number == 10) {
            view.showToast("Congratulations!")
        }
    }

    fun changeTheme() {
        if (!model.isDark) {
            view.changeThemeToDark()
            model.isDark = true
        } else {
            view.changeThemeToLight()
            model.isDark = false
        }
    }
}