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
import com.feriusjosewil.resepai.model.Category

class GridCategoryAdapter(private val listCategory: ArrayList<Category>) : RecyclerView.Adapter<GridCategoryAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_grid_category, parent, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listCategory[position].image)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvTitle.text = listCategory[position].title
    }

    override fun getItemCount(): Int {
        return listCategory.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_image)
        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
    }
}