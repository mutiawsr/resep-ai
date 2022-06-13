package com.feriusjosewil.resepai.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.model.Recipe

class ListRecipeAdapter : RecyclerView.Adapter<ListRecipeAdapter.ListViewHolder>() {

    private val itemList = ArrayList<Recipe>()

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setItemList(item: ArrayList<Recipe>) {
        itemList.clear()
        itemList.addAll(item)
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_recipe, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(itemList[position].image)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)

        holder.tvTitle.text = itemList[position].title
        holder.tvCategory.text = itemList[position].category
        holder.tvLikes.text = itemList[position].likes.toString()
        holder.tvPrice.text = "Rp.${itemList[position].price}"
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(itemList[holder.absoluteAdapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_image)
        var tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        var tvCategory: TextView = itemView.findViewById(R.id.tv_item_category)
        var tvLikes: TextView = itemView.findViewById(R.id.tv_item_likes)
        var tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Recipe)
    }
}