package com.feriusjosewil.resepai.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.adapter.GridCategoryAdapter
import com.feriusjosewil.resepai.adapter.RecipeAdapter
import com.feriusjosewil.resepai.data.CategoryData
import com.feriusjosewil.resepai.data.RecipeData
import com.feriusjosewil.resepai.model.Category
import com.feriusjosewil.resepai.model.Recipe

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var listCategory: ArrayList<Category> = arrayListOf()
    private var listMostLiked: ArrayList<Recipe> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
        val root = inflater.inflate(R.layout.home_fragment, container, false)

        val rvMostLiked = root.findViewById<RecyclerView>(R.id.rv_most_liked)
        rvMostLiked.setHasFixedSize(true)

        listMostLiked.addAll(RecipeData.listData)
        rvMostLiked.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL ,false)
        val listRecipeAdapter = RecipeAdapter(listMostLiked)
        rvMostLiked.adapter = listRecipeAdapter


        val rvCategory = root.findViewById<RecyclerView>(R.id.rv_category)
        rvCategory.setHasFixedSize(true)

        listCategory.addAll(CategoryData.listData)
        rvCategory.layoutManager = GridLayoutManager(activity, 2)
        val gridCategoryAdapter = GridCategoryAdapter(listCategory)
        rvCategory.adapter = gridCategoryAdapter
        homeViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

}