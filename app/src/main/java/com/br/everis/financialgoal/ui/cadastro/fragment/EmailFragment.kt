package com.br.everis.financialgoal.ui.cadastro.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.login.fragment.EmailAlertDialog

class EmailFragment : Fragment() {

    private lateinit var btnContinuar:Button
    private lateinit var btnBackNavBar:AppCompatImageView
    private lateinit var alertDialog: AlertDialog.Builder
    private val dialog = EmailAlertDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_email, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alertDialog = AlertDialog.Builder(view.context)
        val factory = LayoutInflater.from(view.context)
        val viewer = factory.inflate(R.layout.fragment_dialogup_error, null)
        alertDialog.setView(viewer)
        alertDialog.setNegativeButton(
            "OK"
        ) { dialog, which -> dialog.dismiss() }
        alertDialog.show()

        setView(view)
        setClick()
    }

    private fun setClick() {
        btnContinuar.setOnClickListener {

//            parentFragmentManager.beginTransaction().apply {
//                replace(R.id.fragment,NomeFragment.newInstance())
//                addToBackStack(null)
//                commit()
//            }
        }
        btnBackNavBar.setOnClickListener {
            activity?.finish()
        }
    }

    private fun setView(view: View) {
        btnContinuar = view.findViewById(R.id.btn_cadastro_email)
        btnBackNavBar = view.findViewById(R.id.btn_back_cadastro)

    }

    companion object {
        fun newInstance() = EmailFragment()
    }

}

