package com.feriusjosewil.resepai.api

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("regis")
    fun signUp(
        @Field("name") name: String,
        @Field("password") pass: String,
        @Field("notlp") phone: String,
        @Field("alamat") address: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("name") email: String,
        @Field("password") pass: String
    ): Call<LoginResponse>
}