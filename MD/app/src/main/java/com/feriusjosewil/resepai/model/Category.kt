package com.feriusjosewil.resepai.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    var title: String = "",
    var image: Int = 0
) : Parcelable
