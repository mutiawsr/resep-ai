package com.feriusjosewil.resepai.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.model.Recipe

class RecipeAdapter(private val listRecipe: ArrayList<Recipe>) : RecyclerView.Adapter<RecipeAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_most_liked, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listRecipe[position].image)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvTitle.text = listRecipe[position].title
        holder.tvCategory.text = listRecipe[position].category
        holder.tvLikes.text = listRecipe[position].likes.toString()
    }

    override fun getItemCount(): Int {
        return listRecipe.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_image)
        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        var tvCategory: TextView = itemView.findViewById(R.id.tv_item_category)
        var tvLikes: TextView = itemView.findViewById(R.id.tv_item_likes)

    }
}