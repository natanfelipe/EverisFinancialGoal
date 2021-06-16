package com.br.everis.financialgoal.ui.loggedOut

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.br.everis.financialgoal.R
import com.br.everis.financialgoal.ui.cadastro.CadastroActivity
import com.google.android.material.tabs.TabLayout
import java.util.*

class LoggedOutActivity : AppCompatActivity() {

    var currentPage = 0
    private lateinit var timer: Timer
    private lateinit var btnOpenAccount: Button
    private lateinit var btnLogin:Button

    companion object {
        const val DELAY_MS: Long = 500
        const val PERIOD_MS: Long = 3000
    }

    var mViewPager: ViewPager? = null
    private var tabLayout: TabLayout? = null

    var images = intArrayOf(
        R.drawable.logged_out_slide_1,
        R.drawable.logged_out_slide_2,
        R.drawable.logged_out_slide_3,
        R.drawable.logged_out_slide_4,
    )

    var NUM_PAGES = images.size

    private var mViewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_out)

        setView()
        setAdapter()
        btnOpenAccount.setOnClickListener {
            startActivity(Intent(this,CadastroActivity::class.java))
        }


//        btnLogin.setOnClickListener {
//
//        }
    }

    private fun setView() {
        btnOpenAccount = findViewById(R.id.btn_open_account)
        btnLogin = findViewById(R.id.btn_login)
        mViewPager = findViewById(R.id.viewPagerMain)
        tabLayout = findViewById(R.id.tabDots)
        tabLayout!!.setupWithViewPager(mViewPager, true)
    }

    private fun setAdapter() {
        mViewPagerAdapter = ViewPagerAdapter(this@LoggedOutActivity, images)
        mViewPager!!.adapter = mViewPagerAdapter
        val handler = Handler(Looper.getMainLooper())
        val update = Runnable {
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            mViewPager!!.setCurrentItem(currentPage++, true)
        }
        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, DELAY_MS, PERIOD_MS)
    }
}