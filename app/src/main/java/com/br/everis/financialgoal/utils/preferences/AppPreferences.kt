package com.br.everis.financialgoal.utils.preferences

import android.content.Context

class AppPreferences(context:Context) {

    private val mSharedPreferences = context.getSharedPreferences("APP", Context.MODE_PRIVATE)

    fun storeSessionInfo(key: String, Value: Boolean){
        mSharedPreferences.edit().putBoolean(key,Value).apply()
    }

    fun getSessionInfo(key: String): Boolean{
        return mSharedPreferences.getBoolean(key, false) ?: false
    }
}