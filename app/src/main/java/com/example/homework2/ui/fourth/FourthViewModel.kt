package com.example.homework2.ui.fourth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FourthViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is fourth Fragment"
    }
    val text: LiveData<String> = _text
}