package com.br.everis.financialgoal.ui.home.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.yearlysource.model.YearlyModelRequest
import com.br.everis.financialgoal.utils.ChangeFragment
import com.br.everis.financialgoal.utils.cadastro.CadastroEnum
import com.br.everis.financialgoal.utils.dialogup.DialogAlert
import com.br.everis.financialgoal.utils.validators.FieldValidator
import com.br.everis.financialgoal.viewmodel.yearly.YearlyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.NumberFormat
import java.util.*

var DIALOG_TITLE = ""
var DIALOG_TEXT = ""
var DIALOG_POSITIVE_BUTTON = ""

class YearlyFragment (
    private val contextActivity: FragmentActivity
) : Fragment() {

    private lateinit var edtMonthlyPeriod: EditText
    private lateinit var edtMonthlyTax: EditText
    private lateinit var edtUniqueApplicationValue: EditText
    private lateinit var edtFinalValue: EditText
    private lateinit var btnBackNavBar: AppCompatImageView
    private lateinit var btnCalcular: Button
    private lateinit var dialogAlert: DialogAlert
    private lateinit var fieldValidator: FieldValidator
    private lateinit var load : FrameLayout

    private val yearlyViewModel: YearlyViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_yearly, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity as Context
        dialogAlert = DialogAlert()
        fieldValidator = FieldValidator()
        setView(view)
        setClick(activity)
    }

    private fun setClick(context: Context) {

        btnCalcular.setOnClickListener {

            load.visibility = View.VISIBLE

            if (fieldValidator.isValidYearly(
                    edtMonthlyPeriod.text.toString(),
                    edtMonthlyTax.text.toString(),
                    edtUniqueApplicationValue.text.toString(), it)
            ) {
                val calculoObject = YearlyModelRequest(
                    initial = edtUniqueApplicationValue.text.toString().toDouble(),
                    monthly = 0.0,
                    profitability = edtMonthlyTax.text.toString().toFloat(),
                    period = edtMonthlyPeriod.text.toString().toInt(),
                    interestIsMonthly = true
                )

                yearlyViewModel.initialize(calculoObject)
                yearlyViewModel.response.observe(viewLifecycleOwner) { response ->
                    load.visibility = View.GONE
                    val valor = currencyFormat(response.accruedEarnings.toFloat())
                    edtFinalValue.setText(valor)

                }
            } else {
                load.visibility = View.GONE
                dialogAlert.onAlertDialog(it,
                DIALOG_TITLE,
                DIALOG_TEXT,
                DIALOG_POSITIVE_BUTTON
                )
            }
        }

        btnBackNavBar.setOnClickListener {
            ChangeFragment.navigationFragment(
                contextActivity,
                CadastroEnum.CALC_LIST.toString(),
                R.id.fragment_calcs,
                null
            )
        }
    }

    private fun setView(view: View) {
        edtMonthlyPeriod = view.findViewById(R.id.edt_monthly_period)
        edtMonthlyTax = view.findViewById(R.id.edt_monthly_tax)
        edtUniqueApplicationValue = view.findViewById(R.id.edt_unique_application_value)
        edtFinalValue = view.findViewById(R.id.edt_final_value)
        btnBackNavBar = view.findViewById(R.id.btn_back_home)
        btnCalcular = view.findViewById(R.id.btn_calcular)
        load = view.findViewById(R.id.loadingFrameLaoyut_senha)
    }

    companion object {
        fun newInstance(
            contextActivity: FragmentActivity
        ) = YearlyFragment(contextActivity)
    }

    fun currencyFormat(valor: Float) : String{
        val format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);
        format.setCurrency(Currency.getInstance("BRL"));

        return format.format(valor);
    }

}
