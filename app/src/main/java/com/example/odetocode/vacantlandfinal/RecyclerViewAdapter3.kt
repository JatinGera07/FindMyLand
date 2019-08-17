package com.example.odetocode.vacantlandfinal
import android.content.Context
import android.content.Intent
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import java.util.ArrayList
class RecyclerViewAdapter3(private val mContext: Context?, ImageResourceId: ArrayList<String>, location: ArrayList<String>, Desc: ArrayList<String>, id1:ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapter3.ViewHolder>() {
    //vars
    private var mImageResourceId = ArrayList<String>()
    private var mLocation = ArrayList<String>()
    private var mDesc = ArrayList<String>()
    private var mid = ArrayList<String>()
    private var option: RequestOptions

    init {
        mImageResourceId = ImageResourceId
        mLocation = location
        mDesc = Desc
        mid=id1
        option = RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_layout3, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(mContext!!).load(mImageResourceId.get(position)).apply(option).into(holder.imageView)
        holder.locationView.text = mLocation[position]
        holder.descView.text = mDesc[position]
        holder.constraintLayout.setOnClickListener(){
            var inte= Intent(mContext,homeclick::class.java)
           /* inte.putExtra("clickedid",mid[position])
           */
            statedataclass.statedatavariable=mid[position]
            mContext!!.startActivity(inte)

        }
    }

    override fun getItemCount(): Int {
        return mImageResourceId.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var imageView: ImageView
        internal var locationView: TextView
        internal var descView: TextView
        internal var constraintLayout:ConstraintLayout
        init {
            imageView = itemView.findViewById<View>(R.id.recyclerViewItem_imageView3) as ImageView
            locationView = itemView.findViewById<View>(R.id.recyclerView_title3) as TextView
            descView = itemView.findViewById<View>(R.id.recyclerView_desc3) as TextView
            constraintLayout= itemView.findViewById<View>(R.id.constraint3) as ConstraintLayout
        }
    }

    companion object {
        private val TAG = "RecyclerViewAdapter"
    }
}