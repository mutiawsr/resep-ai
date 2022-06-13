package com.feriusjosewil.resepai.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
    private lateinit var etSearchRecipe: EditText

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
        etSearchRecipe = root.findViewById(R.id.et_search_recipe)

        etSearchRecipe.setOnEditorActionListener { _, actionId, _ ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val keyword = etSearchRecipe.text.toString()
                etSearchRecipe.clearFocus()
                val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(requireView().windowToken, 0)

                val intent = Intent(activity, ListRecipeActivity::class.java)
                intent.putExtra(ListRecipeActivity.EXTRA_KEYWORD, keyword)
                startActivity(intent)

                handled = true
            }
            handled
        }

        btnImage.setOnClickListener {
            val intent = Intent(activity, CameraActivity::class.java)
            activity?.startActivity(intent)
        }
        rvMostLiked.setHasFixedSize(true)

        rvMostLiked.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL ,false)
        val mostLikedAdapter = MostLikedAdapter()
        mostLikedAdapter.notifyDataSetChanged()
        rvMostLiked.adapter = mostLikedAdapter
        mostLikedAdapter.setItemList(RecipeData.listData)
        mostLikedAdapter.setOnItemClickCallback(object : MostLikedAdapter.OnItemClickCallback {
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
        homeViewModel.listCategory.observe(viewLifecycleOwner) {

        }
        return root
    }

    override fun onResume() {
        etSearchRecipe.text.clear()
        etSearchRecipe.clearFocus()
        super.onResume()
    }
    private fun showSelectedRecipe(recipe: Recipe) {
        Toast.makeText(activity, recipe.title, Toast.LENGTH_SHORT).show()
    }

    private fun showSelectedCategory(category: Category) {
        Toast.makeText(activity, category.title, Toast.LENGTH_SHORT).show()
    }

}