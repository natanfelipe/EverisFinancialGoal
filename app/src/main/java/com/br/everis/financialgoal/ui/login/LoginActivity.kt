package com.br.everis.financialgoal.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatImageView
import com.br.everis.financialgoal.ui.loggedIn.LoggedInActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.ui.login.fragment.ForgottenPasswordAlertDialog
import com.br.everis.financialgoal.utils.DialogAlert
import com.br.everis.financialgoal.utils.FieldValidator
import com.br.everis.financialgoal.viewmodel.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnLogin : Button
    private lateinit var textForgot : TextView
    private lateinit var btnBackHome : AppCompatImageView
    private lateinit var email : EditText
    private lateinit var senha : EditText
    private lateinit var frame : FrameLayout
    private lateinit var fieldValidator: FieldValidator
    private lateinit var dialogAlert: DialogAlert
    private lateinit var btnOk:TextView
    private lateinit var btnCancelar:TextView
    private lateinit var title: String
    private lateinit var text: String
    private lateinit var positive_button: String

    private val dialog = ForgottenPasswordAlertDialog()
    val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        click()
    }

    fun click() {
        btnLogin = findViewById(R.id.buttonLogin)
        textForgot = findViewById(R.id.textForgot)
        btnBackHome = findViewById(R.id.btnBackHome)


        btnLogin.setOnClickListener(this)
        textForgot.setOnClickListener(this)
        btnBackHome.setOnClickListener(this)

    }

    fun login(){
        frame = findViewById(R.id.frame_laout)
        email = findViewById(R.id.userName)
        senha = findViewById(R.id.password)

        title = getString(R.string.email_alert_title)
        text = getString(R.string.email_alert_text)
        positive_button = getString(R.string.positive_button)

        fieldValidator = FieldValidator()

        if (fieldValidator.isValidEmail(email.text.toString()) == true){
            if(fieldValidator.isValidPassword(senha.text.toString())== true){

                frame.visibility = View.VISIBLE
                val loginDados = LoginModelRequest(email.text.toString().toLowerCase(),senha.text.toString())
                loginViewModel.init(loginDados)
                loginViewModel.response.observe(this){
                    if(it.res == true){
                        frame.visibility = View.GONE
                        startActivity(Intent(this, LoggedInActivity::class.java))
                    }else{
                        frame.visibility = View.GONE
                        Toast.makeText(this,"Deu ruim!",Toast.LENGTH_SHORT).show()
                    }
                }

            }else{
                Toast.makeText(this,"Senha incorreta!",Toast.LENGTH_SHORT).show()
            }

            }else{
            Toast.makeText(this,"E-mail incorreto!",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.buttonLogin ->{
                login()
            }
            R.id.textForgot -> {
                dialog.show(supportFragmentManager,"custom dialog")
            }
            R.id.btnBackHome ->{
                finish()
            }

        }
    }



}
