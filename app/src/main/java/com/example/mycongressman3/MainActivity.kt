package com.example.mycongressman3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {



    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
//        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)

        init()
    }
    fun init(){
        var button_search = b_search
        button_search.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        bottom_tab.setOnNavigationItemReselectedListener {
            if (bottom_tab[0].isEnabled){
                Toast.makeText(applicationContext, "tab1",Toast.LENGTH_SHORT).show() //이제 프레임넣는거!
            }
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
