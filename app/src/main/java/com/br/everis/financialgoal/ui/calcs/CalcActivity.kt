package com.br.everis.financialgoal.ui.calcs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.home.HomeActivity
import com.br.everis.financialgoal.utils.ChangeFragment

class CalcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)

        inflateFragment()
    }

    private fun inflateFragment() {
        val intentCalc:Intent = intent
        val fragment = intentCalc.extras?.get("fragment")?.toString()

        ChangeFragment.navigationFragment(this, fragment, R.id.fragment_calcs, null)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, HomeActivity::class.java))
    }
}