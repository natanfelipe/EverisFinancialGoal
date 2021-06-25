package com.br.everis.financialgoal.ui.login

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.Observer
import com.br.everis.financialgoal.ui.loggedIn.LoggedInActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.ui.login.fragment.ForgottenPasswordAlertDialog
import com.br.everis.financialgoal.utils.DialogAlert
import com.br.everis.financialgoal.utils.DialogSetColor
import com.br.everis.financialgoal.utils.FieldValidator
import com.br.everis.financialgoal.viewmodel.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var btnLogin : Button
    private lateinit var textForgot : TextView
    private lateinit var btnBackHome : AppCompatImageView
    private lateinit var email : EditText
    private lateinit var senha : EditText
    private lateinit var frame : FrameLayout
    private lateinit var fieldValidator: FieldValidator
    private lateinit var dialogAlert: DialogAlert
    private lateinit var title: String


    private val dialog = ForgottenPasswordAlertDialog()
    val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViews()
        fieldValidator = FieldValidator()
    }

    fun initViews() {
        btnLogin = findViewById(R.id.buttonLogin)
        textForgot = findViewById(R.id.textForgot)
        btnBackHome = findViewById(R.id.btnBackHome)
        frame = findViewById(R.id.loadingFrameLaoyut)
        email = findViewById(R.id.userName)
        senha = findViewById(R.id.loginPassword)
        title = getString(R.string.email_alert_title)

        btnLogin.setOnClickListener(this)
        textForgot.setOnClickListener(this)
        btnBackHome.setOnClickListener(this)
    }

        fun login(view: View) {

            if (validator(email.text.toString(),senha.text.toString())) {
               frame.visibility = View.VISIBLE
                val loginDados =LoginModelRequest(email.text.toString().toLowerCase(), senha.text.toString())
                loginViewModel.init(loginDados)
                loginViewModel.response.observe(this) {
                    if (it.res) {
                        frame.visibility = View.GONE
                        startActivity(Intent(this, LoggedInActivity::class.java))
                    } else {
                        frame.visibility = View.GONE
                        onAlertDialogLogin()
                    }
                }
            }else{
                onAlertDialogLogin()
            }
        }

    override fun onClick(v: View) {
        when(v.id){
            R.id.buttonLogin ->{
              login(v)
            }
            R.id.textForgot -> {
                dialog.show(supportFragmentManager,"custom dialog")
            }
            R.id.btnBackHome ->{
                finish()
            }
        }
    }

    fun onAlertDialogLogin() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Usuário inválido")
        builder.setMessage("Login ou senha inválido")
        builder.setPositiveButton("Ok"){dialog, which ->
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE)
    }

    private fun validator(email:String, senha:String) :Boolean{
       if(fieldValidator.isValidEmail(email) && fieldValidator.isValidPassword(senha)) {
           return true
       }else{
           return false
       }
    }
}