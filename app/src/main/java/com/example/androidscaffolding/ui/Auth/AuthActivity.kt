package com.example.androidscaffolding.ui.Auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidscaffolding.R

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        OpeningDialogFragment().show(supportFragmentManager, "GAME_DIALOG")
    }
}