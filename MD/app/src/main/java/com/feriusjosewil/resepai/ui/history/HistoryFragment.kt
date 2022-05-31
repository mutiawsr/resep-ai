package com.feriusjosewil.resepai.ui.history

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.feriusjosewil.resepai.R

class HistoryFragment : Fragment() {

    private lateinit var historyViewModel: HistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        historyViewModel =
            ViewModelProvider(this)[HistoryViewModel::class.java]
        val root = inflater.inflate(R.layout.history_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.tv_history_title)
        historyViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }
}