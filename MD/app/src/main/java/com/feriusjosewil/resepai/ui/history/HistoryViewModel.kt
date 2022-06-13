package com.feriusjosewil.resepai.ui.history

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feriusjosewil.resepai.R

class HistoryViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Waiting API"
    }
    val text: LiveData<String> = _text
}