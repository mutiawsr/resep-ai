package com.feriusjosewil.resepai.api

import com.feriusjosewil.resepai.model.Category
import retrofit2.Call
import retrofit2.http.*

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
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @GET("search/recipe")
    fun getListRecipe(
        @Query("keyword") keyword: String
    ): Call<ListRecipeResponse>

    @GET("allkategori")
    fun getListCategory(
    ): Call<ListCategoryResponse>
}