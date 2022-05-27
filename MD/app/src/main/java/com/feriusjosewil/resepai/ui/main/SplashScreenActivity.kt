package com.feriusjosewil.resepai.ui.main

import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.core.content.res.ResourcesCompat
import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.databinding.ActivitySplashScreenBinding
import com.feriusjosewil.resepai.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setLogo()

    }

    private fun setupView() {
        supportActionBar?.hide()
    }

    private fun setLogo() {
        val paint = binding.tvLogo.paint
        val width = paint.measureText(binding.tvLogo.text.toString())
        val textShader: Shader = LinearGradient(0f, 0f, width, binding.tvLogo.textSize, intArrayOf(
            Color.parseColor("#FE5A1C"),
            Color.parseColor("#FE7C22"),
            Color.parseColor("#FF9E28"),
            Color.parseColor("#FFBF2E"),
            Color.parseColor("#FFE134")
        ), null, Shader.TileMode.REPEAT)

        binding.tvLogo.paint.shader = textShader

        binding.tvLogo.animate().setDuration(1000).alpha(1f).withEndAction {
            val intent = auth()
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }

    private fun auth(): Intent {
        return Intent(this, LoginActivity::class.java)
    }
}