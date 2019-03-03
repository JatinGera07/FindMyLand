package com.example.odetocode.vacantlandfinal

import android.support.v7.app.AppCompatActivity

import android.support.v4.app.NotificationCompat.getExtras
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_filter.*
import kotlinx.android.synthetic.main.home_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class filter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        val state3="Delhi"//to be send
        val cost="1000,200000"
        val area="1224,20005"
        val retrofit = Retrofit.Builder()
                .baseUrl("http://3.18.27.111:4000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        var call = jsonPlaceHolderApi.createPost3(state3,area,cost)
        call.enqueue(object : Callback<Post1> {
            override fun onResponse(call: Call<Post1>, response: Response<Post1>) {

                if (response.isSuccessful) {
                    actfil!!.append("Code: filter" + response.code())
                }
                if (response.body() != null) {
                val post2 = response.body()
                actfil.append(post2!!.data[0].getname())
                }
            }
            override fun onFailure(call: Call<Post1>, t: Throwable) {
                actfil.setText(t.message)
            }
        })
    }
}