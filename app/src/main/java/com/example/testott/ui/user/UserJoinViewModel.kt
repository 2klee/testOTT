package com.example.testott.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserJoinViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is UserJoin Fragment"
    }
    val text: LiveData<String> = _text
}