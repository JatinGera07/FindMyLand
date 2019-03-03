package com.example.odetocode.vacantlandfinal

import android.content.Intent
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.support.v7.widget.Toolbar
import android.widget.Toast

class LocationSpecificActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        var selectedFragment: Fragment? = null

        when (item.itemId) {
            R.id.nav_home -> selectedFragment = StateSpecificFragment()
            R.id.nav_favourites -> selectedFragment = FavouriteFragment()
            R.id.nav_profile -> selectedFragment = ProfileFragment()
        }

        supportFragmentManager.beginTransaction().replace(R.id.fragment_container2,
                selectedFragment!!).commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_specific)

        toolbar = findViewById(R.id.toolbar2) as android.support.v7.widget.Toolbar
        toolbar.title = "HomePage"
        setSupportActionBar(toolbar)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation2)
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)


        supportFragmentManager.beginTransaction().replace(R.id.fragment_container2,
                StateSpecificFragment()).commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.filter_button, menu)
        return true
    }


}
