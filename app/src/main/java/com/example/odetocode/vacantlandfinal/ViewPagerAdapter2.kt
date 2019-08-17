package com.example.odetocode.vacantlandfinal

import android.content.Context
import android.content.Intent
import android.graphics.ColorSpace.Model
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class ViewPagerAdapter2(private val models: List<listDatatype>, private val context: Context?) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return models.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater!!.inflate(R.layout.viewpager_item_layout2, container, false)

        val image:ImageView
        val title: TextView
        val desc: TextView
        title = view.findViewById(R.id.viewpager_title2)
        desc = view.findViewById(R.id.viewpager_desc2)
        image=view.findViewById(R.id.viewpagerItem_imageView2)
        title.setText(models[position].gettitle())
        desc.setText(models[position].getdescription())

        view.setOnClickListener(){
            var inte= Intent(context,homeclick::class.java)
            /*inte.putExtra("clickedid",models[position].getid1())
            */
            statedataclass.statedatavariable=models[position].toString()

            context!!.startActivity(inte)

/*
            Toast.makeText(context,"viewpager ${position}",Toast.LENGTH_LONG).show()
*/
        }
        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}