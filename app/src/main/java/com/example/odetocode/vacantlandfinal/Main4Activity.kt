package com.example.odetocode.vacantlandfinal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main4.*
import android.R.id.edit
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.preference.PreferenceManager



class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        idout.setOnClickListener {
            val ctx = applicationContext
            val sharedPreferences = ctx.getSharedPreferences("n1", Context.MODE_PRIVATE)
            val editor1 = sharedPreferences.edit()
            editor1.putInt("n2",0)
            editor1.commit()
            val settings = PreferenceManager.getDefaultSharedPreferences(applicationContext)
            val editor = settings.edit()
            editor.remove("username")
            var inte=Intent(this,Main2Activity::class.java)
            startActivity(inte)
        }
        }
}
