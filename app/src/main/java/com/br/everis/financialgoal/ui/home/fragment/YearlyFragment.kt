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
                if (validatorPeriod(it) && validatorTax(it) && validatorApplicationValue(it)) {

                    val calculoObject = YearlyModelRequest(
                        initial = edtUniqueApplicationValue.text.toString().toDouble(),
                        month = 0.0,
                        profitability = edtMonthlyTax.text.toString().toFloat(),
                        period = edtMonthlyPeriod.text.toString().toInt(),
                        interestIsMonthly = true
                    )

                    yearlyViewModel.initialize(calculoObject)
                    yearlyViewModel.response.observe(viewLifecycleOwner) { response ->
                        edtFinalValue.setText(response.accruedEarnings.toString())

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
    }

    private fun Float.format(): String {
        val df = DecimalFormat("#.00")
        return df.format(this)
    }

    private fun validatorPeriod(view: View): Boolean {
        if(edtMonthlyPeriod.text.isNotEmpty()) {
            if (!fieldValidator.isValidPeriod(edtMonthlyPeriod.text.toString().toInt())) {
                return true
            } else {
                if (edtMonthlyPeriod.text.toString().toInt() == 0) {
                    dialogAlert.onAlertDialog(
                        view,
                        view.context.getString(R.string.txt_campo_invalido),
                        "Agaboma",
                        "teste11"
                    )
                    return true
                }
            }
        }
        dialogAlert.onAlertDialog(view, view.context.getString(R.string.txt_campo_invalido), "teste11", "teste11")
        return false
    }

    private fun validatorTax(view: View): Boolean {
        if (edtMonthlyTax.text.isNotEmpty()) {
            return fieldValidator.isValidTax(edtMonthlyTax.text.toString().toFloat())
        }
        dialogAlert.onAlertDialog(view, view.context.getString(R.string.txt_campo_invalido), "teste22", "teste22")
        return false
    }

    private fun validatorApplicationValue(view: View): Boolean {
        if (edtUniqueApplicationValue.text.isNotEmpty()) {
           return fieldValidator.isValidUniqueApplication(edtUniqueApplicationValue.text.toString().toDouble())
        }
        dialogAlert.onAlertDialog(view, view.context.getString(R.string.txt_campo_invalido), "teste33", "teste33")
        return false
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
