package com.br.everis.financialgoal.utils.sessionManagment

import android.content.Context
import com.br.everis.financialgoal.utils.preferences.AppPreferences

class SessionManagement(context:Context) {

    companion object{
        const val KEY_SESSION_INFO = "SessionInfo"
    }

    private val mSharedPreferences = AppPreferences(context)

    fun initializeSession(){
        mSharedPreferences.storeSessionInfo(KEY_SESSION_INFO, true)
    }

    fun finishSession(){
        mSharedPreferences.storeSessionInfo(KEY_SESSION_INFO, false)
    }

    fun getInfoSession():Boolean{
        return mSharedPreferences.getSessionInfo(KEY_SESSION_INFO)
    }
}