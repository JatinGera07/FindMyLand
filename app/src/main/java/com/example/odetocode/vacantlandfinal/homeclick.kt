package com.example.odetocode.vacantlandfinal

import android.support.v7.app.AppCompatActivity
import android.support.v4.app.NotificationCompat.getExtras
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_homeclick.*
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.individual_recyclerview_item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class homeclick : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeclick)

    var idf:String=intent.getStringExtra("clickedid")






        val retrofit = Retrofit.Builder()

                .baseUrl("http://3.18.27.111:4000/")

                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        var call = jsonPlaceHolderApi.getiddata("/image-upload/api/getLand/$idf")
        call.enqueue(object : Callback<Post1>{
            override fun onResponse(call: Call<Post1>, response: Response<Post1>) {

                if (response.isSuccessful) {
                }
               if (response.body() != null) {
                   val post1=response.body()
                  land_name!!.setText(post1!!.data[0].Name)
                  location_textview!!.setText(post1!!.data[0].Location)
                 area_textView!!.setText(post1!!.data[0].Area)
                   textview_cost!!.setText(post1!!.data[0].Cost)
              }
           }
            override fun onFailure(call: Call<Post1>, t: Throwable) {
            }
        })
    }
}