package com.feriusjosewil.resepai.api

interface ApiCallback {
    fun onResponse(isSuccess: Boolean, message: String)
}