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

class StateSpecificFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var state2:String
        state2=statedataclass.statedatavariable
       /* val bundle = this.arguments
        if(bundle!=null){
        score = bundle.getString("STRING_KEY")}
       */ /*val iin=Intent()
        var state2= iin.getStringExtra("strtrans")
       *//*state2="Punjab"*/
/*
        val myValue = arguments!!.getString("params")
*/
        val retrofit = Retrofit.Builder()

                .baseUrl("http://3.18.27.111:4000/")

                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)
        var call = jsonPlaceHolderApi.createPost1(state2)
        val view = inflater.inflate(R.layout.landspecific_fragment, container, false)
        val ImageResourceId= ArrayList<String>()
        val location= ArrayList<String>()
        val Desc= ArrayList<String>()
        val id1=ArrayList<String>()

        call.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {

                if (response.isSuccessful) {
                //    textview11!!.append("Code: " + response.code())
                }
                if (response.body() != null) {
                    val post1=response.body()
                    for(i in 0..post1!!.RecentlyAdded.data.size-1)
                    {ImageResourceId.add(post1!!.RecentlyAdded.data[i].getim())
                        location.add(post1!!.RecentlyAdded.data[i].getname())
                        Desc.add(post1!!.RecentlyAdded.data[i].getloc())
                        id1.add(post1!!.RecentlyAdded.data[i].getid())
                    }
                    val ViewPagerList = ArrayList<listDatatype>()
                    for(i in 0..post1!!.RecentlyAdded.data.size-1){
                        ViewPagerList.add(listDatatype(post1!!.CurrentLocation.data[i].getname(),post1!!.CurrentLocation.data[i].getloc(),post1!!.CurrentLocation.data[i].getid()))}

                    val viewPagerAdapter2 = ViewPagerAdapter2(ViewPagerList,context)
                    val viewPager = view.findViewById<ViewPager>(R.id.viewPager2)
                    viewPager.setAdapter(viewPagerAdapter2)
                    viewPager.setPadding(130, 0, 130, 0)


                    val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView2)
                    recyclerView.setLayoutManager(layoutManager)
                    val recyclerViewAdapter2 = RecyclerViewAdapter2(context,ImageResourceId,location,Desc,id1)
                    recyclerView.setAdapter(recyclerViewAdapter2)

                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
         //       textview11!!.setText(t.message)
            }
        })


        return view
    }


}