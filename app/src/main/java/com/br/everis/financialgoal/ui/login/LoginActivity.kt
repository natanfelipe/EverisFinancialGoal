package com.br.everis.financialgoal.ui.login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.LifecycleOwner
import com.br.everis.financialgoal.LoggedInActivity
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelRequest
import com.br.everis.financialgoal.ui.cadastro.CadastroActivity
import com.br.everis.financialgoal.ui.login.fragment.MyFragment
import com.br.everis.financialgoal.viewmodel.login.LoginViewModel
import org.koin.androidx.viewmodel.compat.ScopeCompat.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var btnLogin : Button
    private lateinit var textForgot : TextView
    private lateinit var btnBackHome : AppCompatImageView
    private lateinit var email : EditText
    private lateinit var senha : EditText
    private val dialog = MyFragment()
    val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        click()
    }

    fun click(){
        btnLogin = findViewById(R.id.buttonLogin)
        textForgot = findViewById(R.id.textForgot)
        btnBackHome = findViewById(R.id.btnBackHome)

        btnLogin.setOnClickListener(this)
        textForgot.setOnClickListener(this)
        btnBackHome.setOnClickListener(this)
    }


    fun login(){

        email = findViewById(R.id.userName)
        senha = findViewById(R.id.password)

        if(email.text.toString() != "" && senha.text.toString() != ""){
            val loginDados = LoginModelRequest(email.text.toString().toLowerCase(),senha.text.toString())
            loginViewModel.init(loginDados)
            loginViewModel.response.observe(this){
                if(it.res){
                    startActivity(Intent(this, LoggedInActivity::class.java))
                }else{
                    Toast.makeText(this,"Deu ruim",Toast.LENGTH_SHORT).show()
                }
            }



        }else{
            Toast.makeText(this,"Preencha todos os campos!",Toast.LENGTH_SHORT).show()
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
            else ->{
                Toast.makeText(this, "Não implementado", Toast.LENGTH_SHORT).show()
        }
        }
    }
}
