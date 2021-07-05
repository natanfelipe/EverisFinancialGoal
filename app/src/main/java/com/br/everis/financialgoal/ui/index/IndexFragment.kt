package com.br.everis.financialgoal.ui.index

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.monthly.MonthlyFragment


class IndexFragment(private val contextActivity: FragmentActivity) : Fragment() {
    lateinit var  spinnerIndex :Spinner


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_index, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView(view)
        setClick()
    }



    fun setView(vie: View) {
        spinnerIndex = requireView().findViewById(R.id.spinner_indice)
    }
    private fun setClick() {
        ArrayAdapter.createFromResource(
            contextActivity,
            R.array.indice_correcao,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerIndex.adapter = adapter
        }

    }


    companion object{
        fun newInstance(contextActivity: FragmentActivity) = IndexFragment(contextActivity)
    }
}