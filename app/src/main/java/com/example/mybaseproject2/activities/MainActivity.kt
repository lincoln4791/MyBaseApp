package com.example.mybaseproject2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.asLiveData
import com.example.mybaseproject2.R
import com.example.mybaseproject2.startNewActivity
import com.example.mybaseproject2.data.UserPreferences
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val userPreferences = UserPreferences(this)

        userPreferences.accessToken.asLiveData().observe(this) {
            Log.d("tag", "token is -> $it")
            val activity = if (it == null) AuthActivity::class.java else HomeActivity::class.java
            startNewActivity(activity)
        }


    }
}