package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.example.navigation.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout:DrawerLayout
    private lateinit var actionBarDrawerLayout:ActionBarDrawerToggle
    private lateinit var toolbar:androidx.appcompat.widget.Toolbar
    private lateinit var navigationView:NavigationView

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar=findViewById(R.id.tool_bar)
        setSupportActionBar(toolbar)
        drawerLayout=findViewById(R.id.main_layout)
        navigationView=findViewById(R.id.navigationView)
        actionBarDrawerLayout= ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(actionBarDrawerLayout)
        actionBarDrawerLayout.isDrawerIndicatorEnabled
        actionBarDrawerLayout.syncState()
    }
}