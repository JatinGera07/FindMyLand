package com.example.odetocode.vacantlandfinal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.provider.Settings
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.TextView
import okhttp3.OkHttpClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.location.*


private const val PERMISSION_REQUEST = 10


class LocationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location)
        val retrofit = Retrofit.Builder()
                .baseUrl("http://3.18.27.111:4000/")

                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        var call = jsonPlaceHolderApi.createPost(31.33, 74.21)

        call.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {

                if (response.isSuccessful) {

                    text1!!.setText("Code: " + response.code())
                }
                if (response.body() != null) {
                    val post = response.body();
text1.append(post!!.RecentlyAdded.data[0].getarea())

                }

            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
                text1!!.setText(t.message)
            }
        })
    }}