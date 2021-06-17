package com.br.everis.financialgoal.ui.loggedOut

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.br.everis.financialgoal.R
import java.util.*

class ViewPagerAdapter(
    context: Context,
    var images: IntArray
) : PagerAdapter() {

    var mLayoutInflater: LayoutInflater

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, viewObject: Any): Boolean {
        return view === viewObject as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val itemView: View = mLayoutInflater.inflate(R.layout.activity_viewpager, container, false)

        val imageView:ImageView = itemView.findViewById(R.id.imageViewMain)

        imageView.setImageResource(images[position])

        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, viewObject: Any) {
        container.removeView(viewObject as ConstraintLayout)
    }

    init {
        images = images
        mLayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
}