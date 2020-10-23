package com.example.portal.ui.exams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExamsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is exams Fragment"
    }
    val text: LiveData<String> = _text
}