package com.feriusjosewil.resepai.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.feriusjosewil.resepai.R

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel =
            ViewModelProvider(this)[ProfileViewModel::class.java]
        val root = inflater.inflate(R.layout.profile_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.tv_profile_title)
        profileViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
}