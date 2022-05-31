package com.feriusjosewil.resepai.ui.cart

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.feriusjosewil.resepai.R

class CartFragment : Fragment() {

    private lateinit var cartViewModel: CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cartViewModel =
            ViewModelProvider(this)[CartViewModel::class.java]
        val root = inflater.inflate(R.layout.cart_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.tv_cart_title)
        cartViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
}