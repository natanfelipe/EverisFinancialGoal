package com.br.everis.financialgoal.ui.monthly

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isInvisible
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.monthly.MonthlyModelRequest
import com.br.everis.financialgoal.viewmodel.monthly.MonthlyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MonthlyFragment: Fragment() {

    lateinit var text_navBar: TextView
    lateinit var btn_calcular: Button
    lateinit var btn_back : Button
    lateinit var periodo : EditText
    lateinit var juros: EditText
    lateinit var aplic_inicial : EditText
    lateinit var aplic_mensal : EditText
    lateinit var valor_final : TextView
    lateinit var progressBar : ProgressBar

    val monthlyViewModel : MonthlyViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_monthly, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            setView(view)
            setClick()
        }

        fun setView(v: View){
        text_navBar = v.findViewById(R.id.textNav)
        text_navBar.text = getString(R.string.nav_bar_monthly)
        btn_calcular = v.findViewById(R.id.btn_monthly_calcular)
        periodo = v.findViewById(R.id.edt_periodo_meses)
        juros = v.findViewById(R.id.edt_taxa)
        aplic_inicial = v.findViewById(R.id.edit_val_init)
        aplic_mensal = v.findViewById(R.id.edit_val_mensal)
        valor_final = v.findViewById(R.id.edit_val_final)
        progressBar = v.findViewById(R.id.progressBar_monthly)

    }
    fun setClick(){

        btn_calcular.setOnClickListener {

            val monthlyDados = MonthlyModelRequest(val_inicial = aplic_inicial.text.toString().toDouble(),
            aport_mensal = aplic_mensal.text.toString().toDouble(),
            taxa_juros = juros.text.toString().toFloat(),
            periodo_meses = periodo.text.toString().toInt(),
            juros_mensais = true)
            monthlyViewModel.init(monthlyDados)
            monthlyViewModel.response.observe(viewLifecycleOwner){
                    response -> valor_final.setText(response.ganho_acumulado.toString())
            }
        }
    }

    companion object {

        fun newInstance(contextActivity: FragmentActivity) = MonthlyFragment()

    }
}