package com.feriusjosewil.resepai.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.feriusjosewil.resepai.R
import com.feriusjosewil.resepai.api.ApiCallback
import com.feriusjosewil.resepai.databinding.ActivityLoginBinding
import com.feriusjosewil.resepai.preference.UserPreference
import com.feriusjosewil.resepai.ui.ViewModelFactory
import com.feriusjosewil.resepai.ui.main.MainActivity
import com.feriusjosewil.resepai.ui.main.SplashScreenActivity
import com.feriusjosewil.resepai.ui.register.RegisterActivity

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupViewModel()
        playAnimation()
        setupAction()


        binding.registerTextView.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupView() {
        supportActionBar?.hide()
    }

    private fun playAnimation() {
        val title = ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA, 1f).setDuration(0)
        val emailEditTextLayout = ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val passwordEditTextLayout = ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val login = ObjectAnimator.ofFloat(binding.loginButton, View.ALPHA, 1f).setDuration(100)
        val registerTextView = ObjectAnimator.ofFloat(binding.registerTextView, View.ALPHA, 1f).setDuration(100)

        AnimatorSet().apply {
            playSequentially(title, emailEditTextLayout, passwordEditTextLayout, login, registerTextView)
            startDelay = 100
        }.start()
    }

    private fun setupViewModel() {
        loginViewModel = ViewModelProvider(
            this,
            ViewModelFactory(UserPreference.getInstance(dataStore))
        )[LoginViewModel::class.java]
    }
    private fun setupAction() {
        loginViewModel.isLoading.observe(this) {
            binding.apply {
                if (it) pbLoading.visibility = View.VISIBLE
                else pbLoading.visibility = View.GONE
            }
        }
        binding.apply {
            loginButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                when {
                    email.isEmpty() -> {
                        emailEditTextLayout.error = "Masukkan email"
                    }
                    else -> {
                        loginViewModel.login(email, password, object : ApiCallback {
                            override fun onResponse(isSuccess: Boolean, message: String) {
                                pbLoading.visibility = View.VISIBLE
//                                if(isSuccess) {
//                                    pbLoading.visibility = View.GONE
//                                    Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
//                                    var intent = Intent(this@LoginActivity, SplashScreenActivity::class.java)
//                                    startActivity(intent)
//                                    finish()
//                                } else {
//                                    pbLoading.visibility = View.GONE
//                                    Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
//                                }
                                Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
                            }
                        })
                    }
                }
            }
        }
    }
}