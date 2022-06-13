package com.feriusjosewil.resepai.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feriusjosewil.resepai.api.Client
import com.feriusjosewil.resepai.api.ListRecipeResponse
import com.feriusjosewil.resepai.data.RecipeData
import com.feriusjosewil.resepai.model.Recipe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListRecipeViewModel : ViewModel() {
    val listRecipe = MutableLiveData<ArrayList<Recipe>>()

    fun getListRecipe(keyword: String) {
        Client.instance.getListRecipe(keyword).enqueue(object : Callback<ListRecipeResponse> {
            override fun onResponse(call: Call<ListRecipeResponse>, response: Response<ListRecipeResponse>) {
                if(response.isSuccessful) {
                    listRecipe.postValue(response.body()?.listRecipe)
                }
            }
            override fun onFailure(call: Call<ListRecipeResponse>, t: Throwable) {
                t.message?.let { Log.d("Something went wrong", it) }
            }

        })
    }
    fun getResult(): LiveData<ArrayList<Recipe>> = listRecipe
}