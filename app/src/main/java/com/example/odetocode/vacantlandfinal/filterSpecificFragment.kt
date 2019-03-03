package com.example.odetocode.vacantlandfinal


import android.content.Intent
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.ArrayList
import android.R.attr.defaultValue
import android.widget.Toast

class filterSpecificFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var state3:String
        state3=statedataclass.statedatavariable
        val cost="1000,200000"
        val area="1224,20005"

        val retrofit = Retrofit.Builder()

                .baseUrl("http://3.18.27.111:4000/")

                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        var call = jsonPlaceHolderApi.createPost3(state3,area,cost)
        val view = inflater.inflate(R.layout.filterspecific_fragment, container, false)
        val ImageResourceId= ArrayList<String>()
        val location= ArrayList<String>()
        val Desc= ArrayList<String>()
        val id1=ArrayList<String>()
        call.enqueue(object : Callback<Post1> {
            override fun onResponse(call: Call<Post1>, response: Response<Post1>) {

                if (response.isSuccessful) {
                //    textview11!!.append("Code: " + response.code())
                }
                if (response.body() != null) {
                    val post2=response.body()
                    for(i in 0..post2!!.data.size-1)
                    {ImageResourceId.add(post2!!.data[0].getim())
                        location.add(post2!!.data[0].getloc())
                        Desc.add(post2!!.data[0].getname())
                        id1.add(post2!!.data[0].getid())
                    }


                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView3)
                    recyclerView.setLayoutManager(layoutManager)
                    val recyclerViewAdapter3 = RecyclerViewAdapter3(context,ImageResourceId,location,Desc,id1)
                    recyclerView.setAdapter(recyclerViewAdapter3)

                }
            }
            override fun onFailure(call: Call<Post1>, t: Throwable) {
         //       textview11!!.setText(t.message)
            }
        })


        return view
    }


}