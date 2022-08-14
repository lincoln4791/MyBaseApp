package com.example.mybaseproject2.utils

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mybaseproject2.R


object SystemUtil {

        fun changeStatusBarToDark(activity: Activity, context : Context){
            val window: Window = activity.window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = ContextCompat.getColor(context, R.color.dark_card2)
            }
        }

    fun changeStatusBar(activity: Activity, context : Context){
        val window: Window = activity.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(context, R.color.colorPrimary)
        }
    }


        fun changeNavigationBarColorToDark(activity: Activity){
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                activity.window.navigationBarColor = activity.resources.getColor(R.color.dark_card2);
            }
        }

    fun changeNavigationBarColor(activity: Activity){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.window.navigationBarColor = activity.resources.getColor(R.color.colorPrimary);
        }
    }

        fun changeToolbarToDark(context: Context,toolbar : androidx.appcompat.widget.Toolbar) {
            toolbar.setBackgroundColor(ContextCompat.getColor(context,R.color.dark_card2))
            toolbar.setTitleTextColor(ContextCompat.getColor(context,R.color.dark_textColor4))

        }


        fun changeSystemToDark( activity: Activity,context: Context,toolbar: androidx.appcompat.widget.Toolbar){
            changeStatusBarToDark(activity,context)
            changeToolbarToDark(context,toolbar)
            changeNavigationBarColorToDark(activity)

        }


        fun hideKeyboard(activity: Activity) {
            val imm = activity.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0)
        }


        fun isSystemProvidedDarkThemeOn(context: Context): Boolean {
            return context.resources.configuration.uiMode and
                    Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
        }



}