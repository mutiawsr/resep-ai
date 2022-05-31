package com.feriusjosewil.resepai.ui.favorite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.feriusjosewil.resepai.R

class FavoriteFragment : Fragment() {

    private lateinit var favoriteViewModel: FavoriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoriteViewModel =
            ViewModelProvider(this)[FavoriteViewModel::class.java]
        val root = inflater.inflate(R.layout.favorite_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.tv_favorite_title)
        favoriteViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
}