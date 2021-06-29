package com.br.everis.financialgoal.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.utils.dialogup.DialogAlert
import com.br.everis.financialgoal.utils.validators.FieldValidator
import java.text.DecimalFormat
import kotlin.math.pow

class YearlyFragment (private val contextActivity: FragmentActivity) : Fragment() {

    private lateinit var edtMonthlyPeriod: EditText
    private lateinit var edtMonthlyTax: EditText
    private lateinit var edtUniqueApplicationValue: EditText
    private lateinit var edtFinalValue: EditText
    private lateinit var btnBackNavBar: AppCompatImageView
    private lateinit var btnCalcular: Button
    private lateinit var dialogAlert: DialogAlert
    private lateinit var fieldValidator: FieldValidator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_yearly, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        title = view.context.getString(R.string.email_alert_title)
//        text = view.context.getString(R.string.email_alert_text)
//        positiveButton = view.context.getString(R.string.positive_button)

        dialogAlert = DialogAlert()
        fieldValidator = FieldValidator()
        setView(view)
        setClick()
    }

    private fun setClick() {

        btnCalcular.setOnClickListener {
            if(edtMonthlyPeriod.text.isNotEmpty()
                && edtMonthlyTax.text.isNotEmpty()
                && edtUniqueApplicationValue.text.isNotEmpty()) {
                if (validatorApplicationValue() && validatorPeriod() && validatorTax()) {
                   calcularJurosComposto(
                       edtUniqueApplicationValue.text.toString().toFloat(),
                       edtMonthlyTax.text.toString().toFloat(),
                       edtMonthlyPeriod.text.toString().toInt()
                   )
                }
            } else {
                dialogAlert.onAlertDialog(it, "title", "text", "positiveButton")
            }
        }

        btnBackNavBar.setOnClickListener {
            requireActivity().finish()
        }
    }

    private fun calcularJurosComposto(capital: Float, taxaJuros: Float, periodo: Int) {
        val expo = (1+(taxaJuros/100)).pow(periodo)
        edtFinalValue.setText((capital*expo).format()).toString()
    }

    private fun Float.format(): String {
        val df = DecimalFormat("#.00")
        return df.format(this)
    }

    private fun setView(view: View) {
        edtMonthlyPeriod = view.findViewById(R.id.edt_monthly_period)
        edtMonthlyTax = view.findViewById(R.id.edt_monthly_tax)
        edtUniqueApplicationValue = view.findViewById(R.id.edt_unique_application_value)
        edtFinalValue = view.findViewById(R.id.edt_final_value)
        btnBackNavBar = view.findViewById(R.id.btn_back_home)
        btnCalcular = view.findViewById(R.id.btn_calcular)
    }

    private fun validatorPeriod(): Boolean = fieldValidator.isValidPeriod(edtMonthlyPeriod.text.toString().toInt())
    private fun validatorTax(): Boolean = fieldValidator.isValidTax(edtMonthlyTax.text.toString().toFloat())
    private fun validatorApplicationValue(): Boolean = fieldValidator.isValidUniqueApplication(edtUniqueApplicationValue.text.toString().toFloat())

    companion object {
        fun newInstance(contextActivity: FragmentActivity) = YearlyFragment(contextActivity)
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
