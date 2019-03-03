package com.example.odetocode.vacantlandfinal

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ImageSliderAdapter(private val mContext: Context,imagelist:ArrayList<String>) : PagerAdapter() {
    private var mImageList=ArrayList<String>()//ArrayOf(R.drawable.image3, R.drawable.image3, R.drawable.image3, R.drawable.image3)
    private var option: RequestOptions

init{
    mImageList=imagelist
    option = RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape)

}
    override fun getCount(): Int {
        return mImageList.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var mLayoutinflater:LayoutInflater =  mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE ) as LayoutInflater
        val view = mLayoutinflater!!.inflate(R.layout.  information_viewpager_imageview, container, false)

        val SlideImageView = view.findViewById(R.id.sliding_image) as ImageView

        Glide.with(mContext!!).load(mImageList.get(position)).apply(option).into(SlideImageView)


        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}