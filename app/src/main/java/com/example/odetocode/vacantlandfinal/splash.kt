package com.example.odetocode.vacantlandfinal

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


class splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen)
        val ctx = applicationContext
        var strSavedValue: Int
        val sharedPreferences = ctx.getSharedPreferences("n1", Context.MODE_PRIVATE)

        strSavedValue = sharedPreferences.getInt("n2", 0)
        if(strSavedValue==1){
        var hand= Handler()
        hand.postDelayed(Runnable {var inte= Intent(this,Main2Activity::class.java)
            startActivity(inte)
            finish()},4000)}
   else{
            var hand= Handler()
            hand.postDelayed(Runnable {var inte= Intent(this,Main2Activity::class.java)
                startActivity(inte)
                finish()},4000)
        }
    }
}