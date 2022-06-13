package com.feriusjosewil.resepai.ui.main

import android.content.Context
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
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.databinding.ActivitySplashScreenBinding
import com.feriusjosewil.resepai.preference.UserPreference
import com.feriusjosewil.resepai.ui.ViewModelFactory
import com.feriusjosewil.resepai.ui.login.LoginActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setLogo()

        /* waiting Api */
//        setupViewModel()
        auth(true)

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
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[MainViewModel::class.java]

        mainViewModel.getUser().observe(this) { user ->
            auth(user.isLogin)
        }
    }


    private fun auth(isLoggedIn: Boolean) {
        if (isLoggedIn) {
            binding.tvLogo.animate().setDuration(1000).alpha(1f).withEndAction {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
            }
        } else {
            binding.tvLogo.animate().setDuration(1000).alpha(1f).withEndAction {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
            }
        }
    }
}