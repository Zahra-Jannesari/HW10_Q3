package com.zarisa.hw10_q3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import com.zarisa.hw10_q3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController =navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_profile, R.id.nav_setting,R.id.nav_exit
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
//        binding.navView.setNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.nav_exit -> finish()
//            }
//            true
//        }
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_exit -> {
                    finish()
                    true
                }
            }
            NavigationUI.onNavDestinationSelected(it, navController)
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}