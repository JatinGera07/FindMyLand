package com.example.odetocode.vacantlandfinal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.ImageView

class StateSpecificPage : AppCompatActivity() {

    internal var AreaList = arrayOf("New Delhi", "Mumbai", "Punjab", "Hyderabad", "Orissa", "Chennai")
    internal var AreaImageResourceId = intArrayOf(R.drawable.delhi1, R.drawable.mumbai1, R.drawable.punjab1, R.drawable.hyderabad1, R.drawable.mumbai1, R.drawable.chennai1)
    internal var StateList = arrayOf("Delhi", "Mumbai", "Punjab", "Hyderabad", "Orissa", "Chennai")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN
        decorView.systemUiVisibility = uiOptions

        setContentView(R.layout.location_activity)

        var gridView = findViewById<View>(R.id.gridview) as GridView
        val gridViewCustomAdapter = GridViewCustomAdapter(this, AreaList, AreaImageResourceId)
        gridView.adapter = gridViewCustomAdapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            /*val bundle = Bundle()
            bundle.putString("STRING_KEY", "your score is 20")
            var StateSpecificFragment = StateSpecificFragment()
            StateSpecificFragment.setArguments(bundle)
            */

            statedataclass.statedatavariable=StateList[i]
            val intent = Intent(applicationContext, LocationSpecificActivity::class.java)
//           intent.putExtra("strtrans",StateList[i])
            startActivity(intent)

     }

        val backButtonImageView = findViewById<View>(R.id.backButton_imageview) as ImageView
        backButtonImageView.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }
}
