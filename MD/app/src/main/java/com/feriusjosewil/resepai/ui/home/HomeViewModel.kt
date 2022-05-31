package com.feriusjosewil.resepai.ui.home

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feriusjosewil.resepai.R

class HomeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Home"
    }
    val text: LiveData<String> = _text
}