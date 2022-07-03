package com.example.homework2.ui.fifth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FifthViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is fifth Fragment"
    }
    val text: LiveData<String> = _text
}