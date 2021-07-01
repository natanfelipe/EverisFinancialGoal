package com.br.everis.financialgoal.ui.home.fragment

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
import com.br.everis.financialgoal.utils.dialogup.DialogAlert
import com.br.everis.financialgoal.utils.validators.FieldValidator
import com.br.everis.financialgoal.viewmodel.yearly.YearlyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DecimalFormat

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


        dialogAlert = DialogAlert()
        fieldValidator = FieldValidator()
        setView(view)
        setClick()
    }

    private fun setClick() {

        btnCalcular.setOnClickListener {

            load.visibility = View.VISIBLE

            if (edtMonthlyPeriod.text.toString().isNotEmpty() && edtMonthlyPeriod.text.toString().toDouble() > 2147483647){
                load.visibility = View.GONE
                dialogAlert.onAlertDialog(it,
                    it.context.getString(R.string.txt_campo_invalido_periodo_mensal),
                    "Período em meses muito extenso",
                    it.context.getString(R.string.positive_button)
                )
            } else if (edtMonthlyPeriod.text.toString().isEmpty() || edtMonthlyPeriod.text.toString().toInt() == 0) {
                load.visibility = View.GONE
                dialogAlert.onAlertDialog(it,
                    it.context.getString(R.string.txt_campo_invalido_periodo_mensal),
                    it.context.getString(R.string.txt_periodo_text),
                    it.context.getString(R.string.positive_button)
                )
            } else if (edtMonthlyTax.text.toString().isEmpty() || edtMonthlyTax.text.toString().toFloat() < 0.0000000001F) {
                load.visibility = View.GONE
                dialogAlert.onAlertDialog(
                    it,
                    it.context.getString(R.string.txt_campo_invalido_taxa),
                    it.context.getString(R.string.txt_taxa_text),
                    it.context.getString(R.string.positive_button)
                )
            } else if (edtUniqueApplicationValue.text.toString().isEmpty() || edtUniqueApplicationValue.text.toString().toDouble() == 0.0) {
                load.visibility = View.GONE
                dialogAlert.onAlertDialog(
                    it,
                    it.context.getString(R.string.txt_campo_invalido_valor_aplicacao),
                    it.context.getString(R.string.txt_valor_text),
                    it.context.getString(R.string.positive_button)
                )
            } else {

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
                    edtFinalValue.setText(response.accruedEarnings.toString().toFloat().format())

                }
            }
        }

        btnBackNavBar.setOnClickListener {
            requireActivity().finish()
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

    private fun Float.format(): String {
        val df = DecimalFormat("#.00")
        return df.format(this)
    }

    companion object {
        fun newInstance(
            contextActivity: FragmentActivity
        ) = YearlyFragment(contextActivity)
    }

//    private var current: String = ""

//    override fun onTextChanged(
//        s: CharSequence,
//        start: Int,
//        before: Int,
//        count: Int
//    ) {
//        if (s.toString() != current) {
//            discount_amount_edit_text.removeTextChangedListener(this)
//
//            val cleanString: String = s.replace("""[R$,.]""".toRegex(), "")
//
//            val parsed = cleanString.toDouble()
//            val formatted = NumberFormat.getCurrencyInstance().format((parsed / 100))
//
//            current = formatted
//            discount_amount_edit_text.setText(formatted)
//            discount_amount_edit_text.setSelection(formatted.length)
//
//            discount_amount_edit_text.addTextChangedListener(this)
//        }
//    }

}
