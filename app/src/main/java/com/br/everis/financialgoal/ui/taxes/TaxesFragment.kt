package com.br.everis.financialgoal.ui.taxes

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.yearlysource.model.YearlyModelRequest
import com.br.everis.financialgoal.ui.cadastro.fragment.EmailFragment
import com.br.everis.financialgoal.utils.dialogup.DialogAlert
import com.br.everis.financialgoal.utils.validators.FieldValidator
import com.br.everis.financialgoal.viewmodel.taxes.TaxesViewModel


class TaxesFragment(private val contextActivity: FragmentActivity) : Fragment() {

    private lateinit var taxanual: EditText
    private lateinit var taxmensal: TextView
    private lateinit var btnBackNavBar: AppCompatImageView
    private lateinit var taxesViewModel: TaxesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.taxes_fragment, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView(view)
        setClick()
        taxesViewModel = TaxesViewModel()

        taxanual.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.isNullOrEmpty()) {
                    taxmensal.text = "0"
                } else {
                    val text = taxesViewModel.converterTaxes(s.toString().toDouble())
                    taxmensal.text = text.toString()
                }
            }
        })
    }

    private fun setClick() {

        btnBackNavBar.setOnClickListener {
            requireActivity().finish()
        }
    }
    private fun setView(view: View) {
        taxanual = view.findViewById(R.id.taxanual)
        taxmensal = view.findViewById(R.id.taxmensal)
        btnBackNavBar = view.findViewById(R.id.btn_back_home)
    }

    companion object {
        fun newInstance(contextActivity: FragmentActivity) = TaxesFragment(contextActivity)
    }
 }