package com.feriusjosewil.resepai.api

import com.feriusjosewil.resepai.model.Category

data class ListCategoryResponse (
    val status: Int,
    val response: ArrayList<Category>
)