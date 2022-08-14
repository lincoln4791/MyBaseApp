package com.example.mybaseproject2.ui.activities

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.lifecycleScope
import com.example.mybaseproject2.R
import com.example.mybaseproject2.ui.fragments.home.HomeViewModel
import com.example.mybaseproject2.startNewActivity
import kotlinx.coroutines.launch
import com.example.mybaseproject2.data.UserPreferences
import com.example.mybaseproject2.data.repository.UserRepository
import com.example.mybaseproject2.databinding.ActivityHomeBinding
import com.example.mybaseproject2.utils.SystemUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    @Inject lateinit var userPreferences: UserPreferences
    @Inject lateinit var userRepository: UserRepository

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        initTheme()
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        setUpNavigation()



    }

    private fun initTheme() {
        SystemUtil.changeNavigationBarColor(this)
        SystemUtil.changeStatusBar(this,this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun setUpNavigation(){
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home,
            R.id.nav_gallery,
            R.id.nav_slideshow,
            R.id.navigation_profile,
            R.id.navigation_dashboard,
            R.id.navigation_notifications), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        binding.appBarMain.contentMain.navBottomView.setupWithNavController(navController)
    }

    fun performLogout() = lifecycleScope.launch {
        //viewModel.logout()
        userPreferences.clear()
        userRepository.removeAllUsersDataFromSQL()
        startNewActivity(AuthActivity::class.java)
    }

    override fun onBackPressed() {
        if(binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            showExitDialog()

        }


    }

    private fun showExitDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose an occupation")
        builder.setTitle("Exit")
        builder.setTitle("Are You Sure Want To Exit?")
        builder.setPositiveButton("Yes"
        ) { _, _ ->
            finish()
        }
        builder.setNegativeButton("No"
        ) { dialog, _ -> dialog?.dismiss() }

        val dialog : AlertDialog = builder.create()
        dialog.show()
    }


}