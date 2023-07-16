package com.example.counter5.presenter

import com.example.counter5.Injector
import com.example.counter5.view.MainActivityView

class MainActivityPresenter constructor(var view: MainActivityView) {
    private val model = Injector.getModel()

    fun increase() {
        model.increase()
        view.showNumber(model.number)
        showToastIfAboveTen()
        changeTextColorIfEqualsFifteen()
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

    private fun changeTextColorIfEqualsFifteen() {
        if(model.number == 15) {
            view.changeTextColor()
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