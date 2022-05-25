package com.feriusjosewil.resepai.ui.main

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

        }
        val paint = binding.tvLogo.paint
        val width = paint.measureText(binding.tvLogo.text.toString())
        val textShader: Shader = LinearGradient(0f, 0f, width, binding.tvLogo.textSize, intArrayOf(
            Color.parseColor("#FE5A1C"),
            Color.parseColor("#FE7C22"),
            Color.parseColor("#FF9E28"),
            Color.parseColor("#FFBF2E"),
            Color.parseColor("#FFE134")
        ), null, Shader.TileMode.REPEAT)

        binding.tvLogo.paint.setShader(textShader)

        binding.tvLogo.animate().setDuration(1000).alpha(1f).withEndAction {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}