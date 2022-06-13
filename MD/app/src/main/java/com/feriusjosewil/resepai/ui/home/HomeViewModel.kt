package com.feriusjosewil.resepai.ui.home

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.api.Client
import com.feriusjosewil.resepai.api.ListCategoryResponse
import com.feriusjosewil.resepai.model.Category
import org.checkerframework.checker.units.qual.C
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    val listCategory = MutableLiveData<ListCategoryResponse>()

    fun getCategory(){
        Client.instance.getListCategory().enqueue(object : Callback<ListCategoryResponse> {
            override fun onResponse(
                call: Call<ListCategoryResponse>,
                response: Response<ListCategoryResponse>
            ) {
                if (response.isSuccessful){
                    listCategory.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<ListCategoryResponse>, t: Throwable) {
                t.message?.let { Log.d("Something went wrong", it) }
            }
        })
    }
    fun getResult() : LiveData<ListCategoryResponse> = listCategory
}