package com.example.materialdesignexample.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.materialdesignexample.BaseActivity
import com.example.materialdesignexample.R


class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        init()
    }

    private fun init() {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navigationView, navController)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {

            R.id.id_home -> {
                // nav options to clear backstack
                val navOptions = NavOptions.Builder().setPopUpTo(R.id.main, true).build()
                Navigation.findNavController(this, R.id.nav_host_fragment)
                    .navigate(R.id.homeFragment, null, navOptions)
            }

            R.id.id_setting -> {
                if (isValidDestination(R.id.settingsFragment)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.settingsFragment)
                }
            }

            R.id.id_btns -> {
                if (isValidDestination(R.id.id_btns)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.buttonsFragment)
                }
            }

            R.id.id_chips -> {
                if (isValidDestination(R.id.id_chips)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.chipsFragment)
                }
            }

            R.id.id_cards -> {
                if (isValidDestination(R.id.id_cards)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.cardsFragment)
                }
            }

            R.id.id_tabs -> {
                if (isValidDestination(R.id.id_tabs)) {
                    Navigation.findNavController(this, R.id.nav_host_fragment)
                        .navigate(R.id.tabsFragment)
                }
            }
        }

        item.setChecked(true)
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    fun isValidDestination(destination: Int): Boolean = destination != Navigation.findNavController(
        this,
        R.id.nav_host_fragment
    ).currentDestination!!.id

    //to enable the back araws
    override fun onSupportNavigateUp(): Boolean = NavigationUI.navigateUp(
        Navigation.findNavController(
            this, R.id.nav_host_fragment
        ), drawerLayout
    )

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
                return true
            } else {
                return false
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}

