package com.example.odetocode.vacantlandfinal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

internal class GridViewCustomAdapter(private val mContext: Context, private val AreaList: Array<String>, private val AreaImageResourceId: IntArray) : BaseAdapter() {
   lateinit var view1: View
    lateinit var layoutInflater:LayoutInflater
    override fun getCount(): Int {
        return AreaImageResourceId.size
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {

          layoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        if (view == null) {
            view1 = View(mContext)
            view1 = layoutInflater.inflate(R.layout.gridview_item, null)
            val imageView = view1.findViewById<View>(R.id.area_imageView) as ImageView
            val textView = view1.findViewById<View>(R.id.areaName_textView) as TextView
            imageView.setImageResource(AreaImageResourceId[i])
            textView.text = AreaList[i]
        }
        return view1
    }
}
