package com.example.mybaseproject2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybaseproject2.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }
}