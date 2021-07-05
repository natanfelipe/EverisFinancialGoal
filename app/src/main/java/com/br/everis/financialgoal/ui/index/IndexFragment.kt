package com.br.everis.financialgoal.ui.index

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.monthly.MonthlyFragment
import com.br.everis.financialgoal.utils.ChangeFragment
import com.br.everis.financialgoal.utils.cadastro.CadastroEnum


class IndexFragment(private val contextActivity: FragmentActivity) : Fragment() {
    lateinit var  spinnerIndex :Spinner
    lateinit var text_navBar: TextView
    lateinit var btn_mudar_indice : Button
    lateinit var btn_back: AppCompatImageView
    lateinit var frame_index: FrameLayout


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



    fun setView(view: View) {
        text_navBar = view.findViewById(R.id.textNav)
        text_navBar.text = getString(R.string.title_nav_index)
        spinnerIndex = view.findViewById(R.id.spinner_indice)
        btn_mudar_indice = view.findViewById(R.id.btn_mudar_indice)
        btn_back = view.findViewById(R.id.btn_back_home)
        frame_index = view.findViewById(R.id.loading_frameLayout_index)
    }
    private fun setClick() {
        spinnerIndex.isEnabled = false
        setSpinner()
        btn_mudar_indice.setOnClickListener {
            spinnerIndex.isEnabled = true
        }

        btn_back.setOnClickListener {
            ChangeFragment.navigationFragment(
                contextActivity,
                CadastroEnum.CALC_LIST.toString(),
                R.id.fragment_calcs,
                null
            )
        }



    }
    fun setSpinner(){
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