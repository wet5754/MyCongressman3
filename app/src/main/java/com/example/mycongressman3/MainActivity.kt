package com.example.mycongressman3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    lateinit var fragmentManager: FragmentManager
    lateinit var transaction: FragmentTransaction
    val tab1Fragment = Tab1Fragment()
    val tab2Fragment = Tab2Fragment()
    val tab3Fragment = Tab3Fragment()
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
//        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
        fragmentManager = this.supportFragmentManager
        transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.bottom_tab_frame, tab1Fragment,"tab1").commitAllowingStateLoss()
        init()
    }

    fun init() {
        var button_search = b_search
        button_search.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        bottom_tab.setOnNavigationItemSelectedListener {
            val transaction = fragmentManager.beginTransaction()
            when (it.itemId) {
                R.id.b_timeline -> {
                    var selectedFragment = tab1Fragment
                    transaction.add(R.id.bottom_tab_frame, selectedFragment)

                }
                R.id.b_trending -> {
                    var selectedFragment = tab2Fragment
                    transaction.add(R.id.bottom_tab_frame, selectedFragment)


                }
                R.id.b_my_page -> {
                    var selectedFragment = tab3Fragment
                    transaction.add(R.id.bottom_tab_frame, selectedFragment)


                }
            }
            transaction.commit()
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

//    override fun onSupportNavigateUp(): Boolean {
////        val navController = findNavController(R.id.nav_host_fragment)
////        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//    }
}
