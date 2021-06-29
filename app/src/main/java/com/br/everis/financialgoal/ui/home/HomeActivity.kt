package com.br.everis.financialgoal.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.Button
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.login.LoginActivity
import com.br.everis.financialgoal.utils.sessionManagment.SessionManagement
import java.util.zip.Inflater

class HomeActivity : AppCompatActivity() {

    lateinit var button:Button
    lateinit var sessionManagement: SessionManagement

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sessionManagement = SessionManagement(this)

        setView()

        button.setOnClickListener {
            sessionManagement.finishSession()
            startActivity(Intent(this,LoginActivity::class.java))
            finish()

        }
    }

    private fun setView() {
        button = findViewById(R.id.btn_logout)
    }
}