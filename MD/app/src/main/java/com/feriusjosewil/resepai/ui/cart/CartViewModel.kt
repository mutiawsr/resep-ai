package com.feriusjosewil.resepai.ui.cart

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feriusjosewil.resepai.R

class CartViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Waiting API"
    }
    val text: LiveData<String> = _text
}