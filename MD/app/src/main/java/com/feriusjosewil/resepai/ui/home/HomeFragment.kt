package com.feriusjosewil.resepai.ui.home

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.adapter.GridCategoryAdapter
import com.feriusjosewil.resepai.adapter.MostLikedAdapter
import com.feriusjosewil.resepai.data.CategoryData
import com.feriusjosewil.resepai.data.RecipeData
import com.feriusjosewil.resepai.model.Category
import com.feriusjosewil.resepai.model.Recipe

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]
        val root = inflater.inflate(R.layout.home_fragment, container, false)

        val rvMostLiked = root.findViewById<RecyclerView>(R.id.rv_most_liked)
        val btnImage = root.findViewById<ImageView>(R.id.btn_camera)

        btnImage.setOnClickListener {
            val intent = Intent(activity, CameraActivity::class.java)
            activity?.startActivity(intent)
        }
        rvMostLiked.setHasFixedSize(true)

        rvMostLiked.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL ,false)
        val listRecipeAdapter = MostLikedAdapter()
        listRecipeAdapter.notifyDataSetChanged()
        rvMostLiked.adapter = listRecipeAdapter
        listRecipeAdapter.setItemList(RecipeData.listData)
        listRecipeAdapter.setOnItemClickCallback(object : MostLikedAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Recipe) {
                showSelectedRecipe(data)
            }
        })

        val rvCategory = root.findViewById<RecyclerView>(R.id.rv_category)
        rvCategory.setHasFixedSize(true)

        rvCategory.layoutManager = GridLayoutManager(activity, 2)
        val gridCategoryAdapter = GridCategoryAdapter()
        gridCategoryAdapter.notifyDataSetChanged()
        rvCategory.adapter = gridCategoryAdapter
        gridCategoryAdapter.setItemList(CategoryData.listData)
        gridCategoryAdapter.setOnItemClickCallback(object : GridCategoryAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Category) {
                showSelectedCategory(data)
            }
        })
        homeViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    private fun showSelectedRecipe(recipe: Recipe) {
        Toast.makeText(getActivity(), recipe.title, Toast.LENGTH_SHORT).show()
    }

    private fun showSelectedCategory(category: Category) {
        Toast.makeText(activity, category.title, Toast.LENGTH_SHORT).show()
    }

}