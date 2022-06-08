package com.feriusjosewil.resepai.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.databinding.ActivityListRecipeBinding

class ListRecipeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListRecipeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}