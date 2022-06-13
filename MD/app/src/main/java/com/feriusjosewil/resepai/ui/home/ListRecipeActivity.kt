package com.feriusjosewil.resepai.ui.home

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.adapter.ListRecipeAdapter
import com.feriusjosewil.resepai.adapter.MostLikedAdapter
import com.feriusjosewil.resepai.data.RecipeData
import com.feriusjosewil.resepai.databinding.ActivityListRecipeBinding
import com.feriusjosewil.resepai.model.Recipe

class ListRecipeActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_KEYWORD = "keyword"
    }
    private lateinit var binding : ActivityListRecipeBinding
    private var listRecipeViewModel: ListRecipeViewModel = ListRecipeViewModel()
    private var listRecipeAdapter: ListRecipeAdapter = ListRecipeAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val keyword = intent.getStringExtra(EXTRA_KEYWORD).toString()
        binding.etSearchRecipe.setText(keyword)


        setupView()

        binding.btnBack.setOnClickListener {
            super.onBackPressed()
        }

        binding.apply {
            rvListRecipe.layoutManager = LinearLayoutManager(this@ListRecipeActivity)
            rvListRecipe.setHasFixedSize(true)
            listRecipeAdapter.notifyDataSetChanged()
            rvListRecipe.adapter = listRecipeAdapter

            listRecipeAdapter.setItemList(RecipeData.listData)

            listRecipeAdapter.setOnItemClickCallback(object : ListRecipeAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Recipe) {
                    showSelectedRecipe(data)
                }
            })
        }

        listRecipeViewModel.getResult().observe(this) {
            if (it != null) {
                listRecipeAdapter.setItemList(it)
                showProgressBar(false)
            }
        }
    }

    override fun onStart() {
        binding.etSearchRecipe.clearFocus()
        this.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
//        searchValidation()
        super.onStart()
    }

    private fun setupView() {
        supportActionBar?.hide()
    }

    private fun searchValidation(){
        binding.apply {
            val keyword = etSearchRecipe.text.toString()
            if(keyword.isNotEmpty()) {
                showProgressBar(true)
                listRecipeViewModel.getListRecipe(keyword)
            }

        }
    }

    private fun showProgressBar(isLoading: Boolean) {
        binding.apply {
            if(isLoading) pbLoading.visibility = View.VISIBLE else pbLoading.visibility = View.GONE
        }
    }

    private fun showSelectedRecipe(recipe: Recipe) {
        Toast.makeText(this, recipe.title, Toast.LENGTH_SHORT).show()
    }


}