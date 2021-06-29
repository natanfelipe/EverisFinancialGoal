package com.br.everis.financialgoal.ui.login


import android.app.AlertDialog
import android.graphics.Color
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.ui.loggedIn.LoggedInActivity
import com.br.everis.financialgoal.utils.FieldValidator
import com.br.everis.financialgoal.viewmodel.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.br.everis.financialgoal.ui.home.HomeActivity
import com.br.everis.financialgoal.ui.login.fragment.ForgottenPasswordAlertDialog
import com.br.everis.financialgoal.utils.sessionManagment.SessionManagement

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var btnLogin : Button
    private lateinit var textForgot : TextView
    private lateinit var btnBackHome : AppCompatImageView
    private lateinit var email : EditText
    private lateinit var senha : EditText
    private lateinit var frame : FrameLayout
    private lateinit var title: String
    private lateinit var fieldValidator: FieldValidator
    private lateinit var bundle:Bundle

    private val dialog = ForgottenPasswordAlertDialog()

    val loginViewModel: LoginViewModel by viewModel()
    lateinit var sessionManagement: SessionManagement

    companion object{
        const val FLAG_NAME_BUNDLE = "NAME"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        fieldValidator = FieldValidator()

        initViews()
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
        sessionManagement = SessionManagement(this)
        bundle= Bundle()
    }

        fun login() {

            if(loginViewModel.isValid(email.text.toString(),senha.text.toString())){

                frame.visibility = View.VISIBLE
                val loginDados = LoginModelRequest(email.text.toString().toLowerCase(), senha.text.toString())
                loginViewModel.init(loginDados)
                loginViewModel.response.observe(this) {
                    if (it.res) {
                        frame.visibility = View.GONE
                        sessionManagement.initializeSession(it)
                        startActivity(Intent(this,HomeActivity::class.java))

                    } else {
                        frame.visibility = View.GONE
                        onAlertDialogLogin(loginViewModel.response.value?.message.toString())
                    }
                }
            }else{
                loginViewModel.messageValidator.observe(this, Observer {
                        message -> onAlertDialogLogin(getString(message))
                })
                loginViewModel.messageValidator.removeObservers((this as AppCompatActivity?)!!)
            }
        }

    override fun onClick(v: View) {
        when(v.id){
            R.id.buttonLogin ->{
                login()

            }
            R.id.textForgot -> {
                dialog.show(supportFragmentManager, R.string.tag_dialog.toString())
            }
            R.id.btnBackHome ->{
                finish()
            }
        }
    }

    fun onAlertDialogLogin(message:String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.dialog_title)
        builder.setMessage(message)
        builder.setPositiveButton(R.string.positive_button){dialog, which ->
            dialog.dismiss()
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLUE)
    }
}