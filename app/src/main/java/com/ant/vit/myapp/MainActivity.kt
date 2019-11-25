package com.ant.vit.myapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

/**
 * Created by Antonio Vitiello on 16/09/2019.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val fab: FloatingActionButton = findViewById(R.id.fab)
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

//        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navController = findNavController(R.id.nav_host_fragment)

        initComponents()
    }

    private fun initComponents() {
        setSupportActionBar(toolbar)
//        NavigationUI.setupActionBarWithNavController(this, navController)

        /** SETUP Side Navigation Menu **/
        setupWithNavController(navigationView, navController)
        //navigationView.setupWithNavController(navController)

        /** SETUP ActionBar **/
        // Preparing a set of destinations id that should be considered as top level destinations
        val topLevelDestinationIds =
            setOf(R.id.nav_home, R.id.navGallery, R.id.navSlideshow, R.id.nav_money_receiver)
        appBarConfiguration = AppBarConfiguration(topLevelDestinationIds, drawerLayout)

//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        setupActionBarWithNavController(navController, appBarConfiguration)

//        bottomNavigationView.setupWithNavController(navController)
        setupWithNavController(bottomNavigationView, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item)
    }

    //NavigateUp management
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        if(navController.currentDestination!!.id == R.id.nav_money_sent){
            return navController.popBackStack(R.id.nav_home, false)
        }
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}
