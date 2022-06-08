package com.feriusjosewil.resepai.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    var id: Int = 0,
    var title: String = "",
    var description: String = "",
    var category: String = "",
    var image: Int = 0,
    var ingredient: String = "",
    var step: String = "",
    var likes: Int = 0,
    var price: Int = 0
) : Parcelable