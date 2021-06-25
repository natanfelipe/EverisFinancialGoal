package com.br.everis.financialgoal.ui.login.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelRequest
import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelResponse
import com.br.everis.financialgoal.repository.recovery.RecoveryRepository
import com.br.everis.financialgoal.viewmodel.recovery.RecoveryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyFragment : DialogFragment() {

    private lateinit var btnOk:TextView
    private lateinit var btnCancelar:TextView
    private lateinit var edtEmail:EditText
    private val recoveryViewModel: RecoveryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnOk = view.findViewById(R.id.ok)
        btnCancelar = view.findViewById(R.id.cancelar)
        edtEmail = view.findViewById(R.id.email)

        setClick()
    }

    private fun setClick() {
        btnOk.setOnClickListener {
            val email = edtEmail.text.toString()
           setViewModel(email)
        }
        btnCancelar.setOnClickListener {
            dialog?.cancel()
        }
    }

    private fun setViewModel(email:String) {
    val recoveryModelRequest = RecoveryModelRequest(
        username = email
    )
    recoveryViewModel.initialize(recoveryModelRequest)
    recoveryViewModel.response.observe(viewLifecycleOwner){
        if (it.res){
            dialog?.cancel()
        }else{
            dialog?.cancel()
        }
    }
    }

}