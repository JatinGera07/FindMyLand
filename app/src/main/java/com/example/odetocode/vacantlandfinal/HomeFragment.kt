package com.example.odetocode.vacantlandfinal
import android.view.View
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
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import com.google.gson.JsonObject



import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



import android.support.v4.app.Fragment
import android.view.LayoutInflater

import android.view.ViewGroup
import android.widget.Adapter

import java.util.ArrayList
import kotlin.math.log




import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.location.*


private const val PERMISSION_REQUEST = 10

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)

        val recyclerViewAd = ArrayList<listDatatype>()

        val viewPager = view.findViewById<ViewPager>(R.id.viewPager)
        var mImageResourceId = ArrayList<String>()
        var mLocation = ArrayList<String>()
        var mid = ArrayList<String>()

        var mDesc = ArrayList<String>()
        val retrofit = Retrofit.Builder()
                .baseUrl("http://3.18.27.111:4000/")

                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        var call = jsonPlaceHolderApi.createPost(31.33, 74.21)

        call.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {

                if (response.isSuccessful) {

                    //text1!!.setText("Code: " + response.code())
                }
                if (response.body() != null) {
                    val  post= response.body()
                    for(i in 0..post!!.RecentlyAdded.data.size-1)
                    {mImageResourceId.add(post!!.RecentlyAdded.data[i].getim())
                    mLocation.add(post!!.RecentlyAdded.data[i].getname())
                    mDesc.add(post!!.RecentlyAdded.data[i].getloc())
                        mid.add(post!!.RecentlyAdded.data[i].getid())

                    }
                    val ViewPagerList = ArrayList<listDatatype>()
                    for(i in 0..post!!.RecentlyAdded.data.size-1){
                    ViewPagerList.add(listDatatype(post!!.CurrentLocation.data[i].getname(),post!!.CurrentLocation.data[i].getloc(),post!!.CurrentLocation.data[i].getid()))}


                    val viewPagerAdapter = ViewPagerAdapter(ViewPagerList,context)
                    viewPager.adapter = viewPagerAdapter
                    viewPager.setPadding(130, 0, 130, 0)

                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_View)
                    recyclerView.layoutManager = layoutManager
                    val recyclerViewAdapter = RecyclerViewAdapter(context,mImageResourceId,mLocation,mDesc,mid)
                    recyclerView.adapter = recyclerViewAdapter


                }

            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
               // text1!!.setText(t.message)
            }
        })
        return view
    }

}
