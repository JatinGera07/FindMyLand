package com.example.odetocode.vacantlandfinal

import com.google.gson.annotations.SerializedName
import java.util.*


class Post {
  var RecentlyAdded:RecentlyAdded
    var CurrentLocation:CurrentLocation
    constructor(RecentlyAdded:RecentlyAdded,CurrentLocation:CurrentLocation){
        this.CurrentLocation=CurrentLocation
        this.RecentlyAdded=RecentlyAdded
    }
    fun getRecent():RecentlyAdded{
        return RecentlyAdded
    }
}