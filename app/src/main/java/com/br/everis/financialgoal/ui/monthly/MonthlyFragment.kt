package com.br.everis.financialgoal.ui.monthly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R

class MonthlyFragment: Fragment() {

    lateinit var text_navBar: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_monthly, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            setView(view)
        }

        fun setView(v: View){
        text_navBar = v.findViewById(R.id.textNav)
        text_navBar.text = getString(R.string.nav_bar_monthly)
    }



    companion object {

        fun newInstance(contextActivity: FragmentActivity) = MonthlyFragment()

    }
}