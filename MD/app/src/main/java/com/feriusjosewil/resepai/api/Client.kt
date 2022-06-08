package com.feriusjosewil.resepai.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    private const val BASE_URL = "https://resepai-backend-vlbqdtksba-uc.a.run.app/v/"

    private val client = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create()).build()

    val instance: Api = client.create(Api::class.java)
}