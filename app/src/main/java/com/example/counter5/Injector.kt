package com.example.counter5

import com.example.counter5.model.CounterModel
import com.example.counter5.presenter.CounterPresenter
import com.example.counter5.view.CounterView

class Injector {
    companion object {
        fun getModel() = CounterModel()
         fun getPesenter(view: CounterView) = CounterPresenter(view)
    }
}