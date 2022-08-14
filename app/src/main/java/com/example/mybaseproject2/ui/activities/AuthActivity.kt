package com.example.mybaseproject2.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mybaseproject2.R
import com.example.mybaseproject2.utils.SystemUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTheme()
        setContentView(R.layout.activity_auth)
    }

    private fun initTheme() {
        SystemUtil.changeNavigationBarColor(this)
        SystemUtil.changeStatusBar(this,this)
    }

}