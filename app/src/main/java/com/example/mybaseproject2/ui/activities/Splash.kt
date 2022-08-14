package com.example.mybaseproject2.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.mybaseproject2.R
import com.example.mybaseproject2.utils.SystemUtil

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTheme()
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)




        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }

    private fun initTheme() {
        SystemUtil.changeNavigationBarColor(this)
        SystemUtil.changeStatusBar(this,this)
    }
}