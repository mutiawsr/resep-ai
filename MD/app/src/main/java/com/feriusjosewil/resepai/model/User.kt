package com.feriusjosewil.resepai.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @SerializedName("userid")
    val userId: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("alamat")
    val address: String,
    @SerializedName("no_hp")
    val phone: String,
    @SerializedName("photourl")
    val photoUrl: String,
    val isLogin: Boolean
) : Parcelable