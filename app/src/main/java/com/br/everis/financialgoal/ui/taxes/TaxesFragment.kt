package com.br.everis.financialgoal.ui.taxes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.cadastro.fragment.EmailFragment


class TaxesFragment(private val contextActivity: FragmentActivity) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.taxes_fragment, container, false)
    }
    companion object {
        fun newInstance(contextActivity: FragmentActivity) = TaxesFragment(contextActivity)
    }
 }