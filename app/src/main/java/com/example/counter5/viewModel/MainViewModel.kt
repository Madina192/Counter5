package com.example.counter5.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var number = MutableLiveData<Int>(0)
    var isDark = MutableLiveData<Boolean>(false)

    fun increase() {
        number.postValue(number.value!! + 1)
    }

    fun decrease() {
        if (number.value!! > 0) {
            number.postValue(number.value!! - 1)
        }
    }

    fun changeBooleanState() {
        isDark.value = !isDark.value!!
    }
}