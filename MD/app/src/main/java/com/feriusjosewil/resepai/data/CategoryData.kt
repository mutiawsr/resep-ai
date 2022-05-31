package com.feriusjosewil.resepai.data

import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.model.Category

object CategoryData {
    private val categoryTitle = arrayOf(
        "Appetizer",
        "Japanese",
        "Korean",
        "Chinese Food"
    )

    private val categoryImage = intArrayOf(
        R.drawable.fried_wontons,
        R.drawable.japanese,
        R.drawable.korean,
        R.drawable.chinese_food
    )

    val listData: ArrayList<Category>
        get() {
            val list = arrayListOf<Category>()
            for (position in categoryTitle.indices) {
                val category = Category()
                category.title = categoryTitle[position]
                category.image = categoryImage[position]
                list.add(category)
            }
            return list
        }

}