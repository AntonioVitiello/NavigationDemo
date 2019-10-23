package com.ant.vit.myapp

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Antonio Vitiello on 16/09/2019.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        //ext: val navController = findNavController(R.id.nav_host_fragment)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        initComponents()
    }

    private fun initComponents() {
        /** SETUP Side Navigation Menu **/
        NavigationUI.setupWithNavController(navigationView, navController)
        //navigationView.setupWithNavController(navController)

        /** SETUP ActionBar **/
        // Preparing a set of destinations id that should be considered as top level destinations
        val topLevelDestinationIds =
            setOf(R.id.nav_home, R.id.navGallery, R.id.navSlideshow, R.id.nav_money_receiver)
        appBarConfiguration = AppBarConfiguration(topLevelDestinationIds, drawerLayout)
        //ext: setupActionBarWithNavController(navController, appBarConfiguration)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
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
