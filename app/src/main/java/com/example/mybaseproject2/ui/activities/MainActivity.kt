package com.example.mybaseproject2.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.asLiveData
import com.example.mybaseproject2.R
import com.example.mybaseproject2.startNewActivity
import com.example.mybaseproject2.data.UserPreferences
import com.example.mybaseproject2.utils.SystemUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTheme()
        setContentView(R.layout.activity_main2)

        val userPreferences = UserPreferences(this)

        userPreferences.accessToken.asLiveData().observe(this) {
            Log.d("tag", "token is -> $it")
            val activity = if (it == null) AuthActivity::class.java else HomeActivity::class.java
            startNewActivity(activity)
        }


    }
    private fun initTheme() {
        SystemUtil.changeNavigationBarColor(this)
        SystemUtil.changeStatusBar(this,this)
    }
}