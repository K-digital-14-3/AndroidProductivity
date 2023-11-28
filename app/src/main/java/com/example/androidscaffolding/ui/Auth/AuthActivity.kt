package com.example.androidscaffolding.ui.Auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidscaffolding.R
import com.example.androidscaffolding.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    lateinit var binding : ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, IntroFragment())
                .commit()
        }
    }
}