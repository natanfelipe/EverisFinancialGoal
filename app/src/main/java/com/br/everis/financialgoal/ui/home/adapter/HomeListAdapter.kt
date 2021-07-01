package com.br.everis.financialgoal.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.utils.home.ClickItemHome
import java.util.*
import kotlin.collections.ArrayList

class HomeListAdapter(
    private val listCards: ArrayList<String>,
    private val listImages: ArrayList<Int>,
    private var listener: ClickItemHome
    ) : RecyclerView.Adapter<HomeListAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(
        itemView: View,
        private var listener: ClickItemHome
    ) : RecyclerView.ViewHolder(itemView) {
        private val tv_card: AppCompatTextView = itemView.findViewById(R.id.tv_card)
        private val image_card: AppCompatImageView = itemView.findViewById(R.id.img_card)

        fun bind(card:String, imagem:Int) {
            itemView.setOnClickListener {
                listener.ClickItemHome(card)
            }
            tv_card.text = card.toLowerCase(Locale.ROOT)
            image_card.load(imagem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_list_item, parent, false)
        return HomeViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(listCards[position],listImages[position])
    }

    override fun getItemCount(): Int {
        return listCards.size
    }
}
