package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.navigation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout:DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        // XML Fragment container must be replaced with fragment label
        setContentView(binding.root)
        drawerLayout = binding.mainDrawerLayout
        val navController = this.findNavController(R.id.fragmentContainerView)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        NavigationUI.setupWithNavController(binding.navigationView, navController)
        Timber.i("onCreate Method")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Method")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Method")

    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Method")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Method")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Method")
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController= findNavController(R.id.fragmentContainerView)
        return NavigationUI.navigateUp(navController,appBarConfiguration)
    }
}