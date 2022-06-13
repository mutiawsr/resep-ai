package com.feriusjosewil.resepai.api

import com.feriusjosewil.resepai.model.User

data class LoginResponse (
    val status: Int,
    val response: ArrayList<User>
)