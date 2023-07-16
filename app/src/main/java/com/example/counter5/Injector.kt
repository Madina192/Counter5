package com.example.counter5

import com.example.counter5.model.MainActivityModel
import com.example.counter5.presenter.MainActivityPresenter
import com.example.counter5.view.MainActivityView

class Injector {
    companion object {
        fun getModel() = MainActivityModel()
         fun getPresenter(view: MainActivityView) = MainActivityPresenter(view)
    }
}