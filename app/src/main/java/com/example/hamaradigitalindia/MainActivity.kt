package com.example.hamaradigitalindia

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var nav_view : NavigationView
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawer)
        nav_view = findViewById(R.id.nav_view)

        appBarConfiguration  = AppBarConfiguration(setOf(R.id.home_item,R.id.about_item),drawerLayout)


        toolbar.setupWithNavController(navController,appBarConfiguration)
        nav_view.setupWithNavController(navController)
        setSupportActionBar(toolbar)

        val actionBarDrawerToggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        actionBarDrawerToggle.drawerArrowDrawable.setColor(resources.getColor(R.color.white))
        actionBarDrawerToggle.syncState()


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}