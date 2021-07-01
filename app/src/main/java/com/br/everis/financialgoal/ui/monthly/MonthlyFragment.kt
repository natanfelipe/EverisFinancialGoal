package com.br.everis.financialgoal.ui.monthly

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.monthly.MonthlyModelRequest
import com.br.everis.financialgoal.viewmodel.monthly.MonthlyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.NumberFormat


class MonthlyFragment : Fragment() {

    lateinit var text_navBar: TextView
    lateinit var btn_calcular: Button
    lateinit var btn_back: AppCompatImageView
    lateinit var periodo: EditText
    lateinit var juros: EditText
    lateinit var aplic_inicial: EditText
    lateinit var aplic_mensal: EditText
    lateinit var valor_final: TextView
    lateinit var progressBar: ProgressBar
    lateinit var frame_monthly: FrameLayout


    val monthlyViewModel: MonthlyViewModel by viewModel()


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

    fun setView(v: View) {
        text_navBar = v.findViewById(R.id.textNav)
        text_navBar.text = getString(R.string.nav_bar_monthly)
        btn_calcular = v.findViewById(R.id.btn_monthly_calcular)
        periodo = v.findViewById(R.id.edt_periodo_meses)
        juros = v.findViewById(R.id.edt_taxa)
        aplic_inicial = v.findViewById(R.id.edit_val_init)
        aplic_mensal = v.findViewById(R.id.edit_val_mensal)
        valor_final = v.findViewById(R.id.edit_val_final)
        progressBar = v.findViewById(R.id.progressBar_monthly)
        btn_back = v.findViewById(R.id.btnBackHome)
        frame_monthly = v.findViewById(R.id.loading_frameLayout_monthly)

    }

    fun setClick() {

        btn_calcular.setOnClickListener {
            if (monthlyViewModel.isValid(
                    periodo = periodo.text.toString(),
                    juros = juros.text.toString(),
                    aplic_inicial = aplic_inicial.text.toString(),
                    aplic_mensal = aplic_mensal.text.toString()
                )
            ) {
                frame_monthly.visibility = View.VISIBLE
                val monthlyDados = MonthlyModelRequest(
                    val_inicial = aplic_inicial.text.toString().toDouble(),
                    aport_mensal = aplic_mensal.text.toString().toDouble(),
                    taxa_juros = juros.text.toString().toFloat(),
                    periodo_meses = periodo.text.toString().toInt(),
                    juros_mensais = true
                )
                monthlyViewModel.init(monthlyDados)
                monthlyViewModel.response.observe(viewLifecycleOwner) { response ->
                    frame_monthly.visibility = View.GONE
                    val resp = response.ganho_acumulado.toString().toDouble()
                    valor_final.setText(NumberFormat.getCurrencyInstance().format(resp))
                }
            } else {
                frame_monthly.visibility = View.GONE
                monthlyViewModel.messageMonthlyValidator.observe(viewLifecycleOwner) { message ->
                    onAlertDialogLogin(getString(message))
                }
            }
        }
        btn_back.setOnClickListener {
            onAlertDialogLogin("Não implementado")
        }
    }

    fun onAlertDialogLogin(message: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(R.string.erro_dialog_monthly)
        builder.setMessage(message)
        builder.setPositiveButton(R.string.positive_button) { dialog, which ->
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE)
    }

    companion object {

        fun newInstance(contextActivity: FragmentActivity) = MonthlyFragment()

    }
}