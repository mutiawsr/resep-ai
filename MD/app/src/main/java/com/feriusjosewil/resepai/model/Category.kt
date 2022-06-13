package com.feriusjosewil.resepai.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    @SerializedName("nama_kategori")
    var title: String = "",
    @SerializedName("image_url")
    var image: Int = 0
) : Parcelable
