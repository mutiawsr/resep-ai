package com.feriusjosewil.resepai.api

import com.feriusjosewil.resepai.model.Recipe
import com.google.gson.annotations.SerializedName

data class ListRecipeResponse (
    @SerializedName("items")
    val listRecipe : ArrayList<Recipe>
)