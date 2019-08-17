package com.example.odetocode.vacantlandfinal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_filter_page.*

class FilterPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_page)
        var minc:Int=0
        var maxc:Int=0
        var mina:Int=0
        var maxa:Int=0
        if(upto50cost.isSelected){
            minc=0
            maxc=50
        }
        if(upto100cost.isSelected){
            minc=50
            maxc=100
        }
        if(upto200cost.isSelected){
            minc=100
            maxc=200
        }
        if(upto200cost.isSelected){
            minc=100
            maxc=200
        }
        if(upto200cost.isSelected){
            minc=100
            maxc=200
        }
        if(upto200cost.isSelected){
            minc=100
            maxc=200
        }
    }
}
