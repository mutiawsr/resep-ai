package com.feriusjosewil.resepai.data

import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.model.Category
import com.feriusjosewil.resepai.model.Recipe

object RecipeData {

    private val recipeId = arrayOf(
        0,
        1,
        2,
        3,
        4,
        5,
        6,
        7
    )

    private val recipeTitle = arrayOf(
        "Fried Wontons",
        "Fruit Salad",
        "Garlic Herb Cheese Bombs",
        "Mini Quiches",
        "Nyonya Kuih Pie Tee",
        "Parmesan Sweet Potato Cheese",
        "Parmesan Zucchini Chips",
        "Spring Rolls"
    )

    private val recipeCategory = arrayOf(
        "Appetizer",
        "Japanese",
        "Korean",
        "Chinese Food",
        "Appetizer",
        "Japanese",
        "Korean",
        "Chinese Food"
    )

    private val recipeImage = intArrayOf(
        R.drawable.fried_wontons,
        R.drawable.fruit_salad,
        R.drawable.garlic_herb_cheese_bombs,
        R.drawable.mini_quiches,
        R.drawable.nyonya_kuih_pie_tee,
        R.drawable.parmesan_sweet_potato_fries,
        R.drawable.parmesan_zucchini_chips,
        R.drawable.spring_rolls,
    )

    private val recipeLikes = arrayOf(
        10,
        21,
        32,
        43,
        54,
        65,
        76,
        87
    )

    private val recipePrice = arrayOf(
        99020,
        44300,
        38000,
        41000,
        43500,
        42100,
        54000,
        24000
    )

    private val recipeIngredient = arrayOf(
        "200g chicken, 100g shrimp, ½ teaspoon soy sauce, ½ teaspoon sesame oil, 3 dashes ground white pepper, 400ml water, 450ml vegetable oil",
        "200g chicken, 100g shrimp, ½ teaspoon soy sauce, ½ teaspoon sesame oil, 3 dashes ground white pepper, 400ml water, 450ml vegetable oil",
        "200g chicken, 100g shrimp, ½ teaspoon soy sauce, ½ teaspoon sesame oil, 3 dashes ground white pepper, 400ml water, 450ml vegetable oil",
        "200g chicken, 100g shrimp, ½ teaspoon soy sauce, ½ teaspoon sesame oil, 3 dashes ground white pepper, 400ml water, 450ml vegetable oil",
        "200g chicken, 100g shrimp, ½ teaspoon soy sauce, ½ teaspoon sesame oil, 3 dashes ground white pepper, 400ml water, 450ml vegetable oil",
        "200g chicken, 100g shrimp, ½ teaspoon soy sauce, ½ teaspoon sesame oil, 3 dashes ground white pepper, 400ml water, 450ml vegetable oil",
        "200g chicken, 100g shrimp, ½ teaspoon soy sauce, ½ teaspoon sesame oil, 3 dashes ground white pepper, 400ml water, 450ml vegetable oil",
        "200g chicken, 100g shrimp, ½ teaspoon soy sauce, ½ teaspoon sesame oil, 3 dashes ground white pepper, 400ml water, 450ml vegetable oil"
    )

    private val recipeStep = arrayOf(
        "1. In a bowl, mix the ground pork, shrimp, soy sauce, sesame oil and white pepper together. Stir to combine well to form a sticky filling. 2. To wrap the wontons, lay a piece of the wonton wrapper on your palm and add ½ tablespoon of the filling in the middle of the wrapper. (Use 1 teaspoon filling if you are a beginner.) Dip your index finger into the sealing water and trace it on the outer edges of the wonton wrapper. 3. You can wrap the wontons three ways. To make a triangle, just fold it up to form a triangle. Pinch the edges to seal tight. To make them into the pretty shape (far left in the above picture), just pull the two corners of the triangle down so one overlaps the other, pinch and seal with water. To make them into Hong Kong style wonton (far right in the above picture), please watch my video at the top of this post. 4. Heat up some oil for deep-frying. Once the oil is fully heated, deep fry the wontons until golden brown. Drain the excess oil with paper towels. Serve hot with Chinese sweet and sour sauce or Thai sweet chili sauce.",
        "1. In a bowl, mix the ground pork, shrimp, soy sauce, sesame oil and white pepper together. Stir to combine well to form a sticky filling. 2. To wrap the wontons, lay a piece of the wonton wrapper on your palm and add ½ tablespoon of the filling in the middle of the wrapper. (Use 1 teaspoon filling if you are a beginner.) Dip your index finger into the sealing water and trace it on the outer edges of the wonton wrapper. 3. You can wrap the wontons three ways. To make a triangle, just fold it up to form a triangle. Pinch the edges to seal tight. To make them into the pretty shape (far left in the above picture), just pull the two corners of the triangle down so one overlaps the other, pinch and seal with water. To make them into Hong Kong style wonton (far right in the above picture), please watch my video at the top of this post. 4. Heat up some oil for deep-frying. Once the oil is fully heated, deep fry the wontons until golden brown. Drain the excess oil with paper towels. Serve hot with Chinese sweet and sour sauce or Thai sweet chili sauce.",
        "1. In a bowl, mix the ground pork, shrimp, soy sauce, sesame oil and white pepper together. Stir to combine well to form a sticky filling. 2. To wrap the wontons, lay a piece of the wonton wrapper on your palm and add ½ tablespoon of the filling in the middle of the wrapper. (Use 1 teaspoon filling if you are a beginner.) Dip your index finger into the sealing water and trace it on the outer edges of the wonton wrapper. 3. You can wrap the wontons three ways. To make a triangle, just fold it up to form a triangle. Pinch the edges to seal tight. To make them into the pretty shape (far left in the above picture), just pull the two corners of the triangle down so one overlaps the other, pinch and seal with water. To make them into Hong Kong style wonton (far right in the above picture), please watch my video at the top of this post. 4. Heat up some oil for deep-frying. Once the oil is fully heated, deep fry the wontons until golden brown. Drain the excess oil with paper towels. Serve hot with Chinese sweet and sour sauce or Thai sweet chili sauce.",
        "1. In a bowl, mix the ground pork, shrimp, soy sauce, sesame oil and white pepper together. Stir to combine well to form a sticky filling. 2. To wrap the wontons, lay a piece of the wonton wrapper on your palm and add ½ tablespoon of the filling in the middle of the wrapper. (Use 1 teaspoon filling if you are a beginner.) Dip your index finger into the sealing water and trace it on the outer edges of the wonton wrapper. 3. You can wrap the wontons three ways. To make a triangle, just fold it up to form a triangle. Pinch the edges to seal tight. To make them into the pretty shape (far left in the above picture), just pull the two corners of the triangle down so one overlaps the other, pinch and seal with water. To make them into Hong Kong style wonton (far right in the above picture), please watch my video at the top of this post. 4. Heat up some oil for deep-frying. Once the oil is fully heated, deep fry the wontons until golden brown. Drain the excess oil with paper towels. Serve hot with Chinese sweet and sour sauce or Thai sweet chili sauce.",
        "1. In a bowl, mix the ground pork, shrimp, soy sauce, sesame oil and white pepper together. Stir to combine well to form a sticky filling. 2. To wrap the wontons, lay a piece of the wonton wrapper on your palm and add ½ tablespoon of the filling in the middle of the wrapper. (Use 1 teaspoon filling if you are a beginner.) Dip your index finger into the sealing water and trace it on the outer edges of the wonton wrapper. 3. You can wrap the wontons three ways. To make a triangle, just fold it up to form a triangle. Pinch the edges to seal tight. To make them into the pretty shape (far left in the above picture), just pull the two corners of the triangle down so one overlaps the other, pinch and seal with water. To make them into Hong Kong style wonton (far right in the above picture), please watch my video at the top of this post. 4. Heat up some oil for deep-frying. Once the oil is fully heated, deep fry the wontons until golden brown. Drain the excess oil with paper towels. Serve hot with Chinese sweet and sour sauce or Thai sweet chili sauce.",
        "1. In a bowl, mix the ground pork, shrimp, soy sauce, sesame oil and white pepper together. Stir to combine well to form a sticky filling. 2. To wrap the wontons, lay a piece of the wonton wrapper on your palm and add ½ tablespoon of the filling in the middle of the wrapper. (Use 1 teaspoon filling if you are a beginner.) Dip your index finger into the sealing water and trace it on the outer edges of the wonton wrapper. 3. You can wrap the wontons three ways. To make a triangle, just fold it up to form a triangle. Pinch the edges to seal tight. To make them into the pretty shape (far left in the above picture), just pull the two corners of the triangle down so one overlaps the other, pinch and seal with water. To make them into Hong Kong style wonton (far right in the above picture), please watch my video at the top of this post. 4. Heat up some oil for deep-frying. Once the oil is fully heated, deep fry the wontons until golden brown. Drain the excess oil with paper towels. Serve hot with Chinese sweet and sour sauce or Thai sweet chili sauce.",
        "1. In a bowl, mix the ground pork, shrimp, soy sauce, sesame oil and white pepper together. Stir to combine well to form a sticky filling. 2. To wrap the wontons, lay a piece of the wonton wrapper on your palm and add ½ tablespoon of the filling in the middle of the wrapper. (Use 1 teaspoon filling if you are a beginner.) Dip your index finger into the sealing water and trace it on the outer edges of the wonton wrapper. 3. You can wrap the wontons three ways. To make a triangle, just fold it up to form a triangle. Pinch the edges to seal tight. To make them into the pretty shape (far left in the above picture), just pull the two corners of the triangle down so one overlaps the other, pinch and seal with water. To make them into Hong Kong style wonton (far right in the above picture), please watch my video at the top of this post. 4. Heat up some oil for deep-frying. Once the oil is fully heated, deep fry the wontons until golden brown. Drain the excess oil with paper towels. Serve hot with Chinese sweet and sour sauce or Thai sweet chili sauce.",
        "1. In a bowl, mix the ground pork, shrimp, soy sauce, sesame oil and white pepper together. Stir to combine well to form a sticky filling. 2. To wrap the wontons, lay a piece of the wonton wrapper on your palm and add ½ tablespoon of the filling in the middle of the wrapper. (Use 1 teaspoon filling if you are a beginner.) Dip your index finger into the sealing water and trace it on the outer edges of the wonton wrapper. 3. You can wrap the wontons three ways. To make a triangle, just fold it up to form a triangle. Pinch the edges to seal tight. To make them into the pretty shape (far left in the above picture), just pull the two corners of the triangle down so one overlaps the other, pinch and seal with water. To make them into Hong Kong style wonton (far right in the above picture), please watch my video at the top of this post. 4. Heat up some oil for deep-frying. Once the oil is fully heated, deep fry the wontons until golden brown. Drain the excess oil with paper towels. Serve hot with Chinese sweet and sour sauce or Thai sweet chili sauce."
    )

    val listData: ArrayList<Recipe>
        get() {
            val list = arrayListOf<Recipe>()
            for (position in recipeTitle.indices) {
                val recipe = Recipe()
                recipe.id = recipeId[position]
                recipe.title = recipeTitle[position]
                recipe.category = recipeCategory[position]
                recipe.likes = recipeLikes[position]
                recipe.ingredient = recipeIngredient[position]
                recipe.step = recipeStep[position]
                recipe.image = recipeImage[position]
                recipe.price = recipePrice[position]
                list.add(recipe)
            }
            return list
        }

}