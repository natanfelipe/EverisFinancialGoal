package com.br.everis.financialgoal.utils.sessionManagment

import android.content.Context
import com.br.everis.financialgoal.data.datasource.model.login.LoginModelResponse
import com.br.everis.financialgoal.utils.preferences.AppPreferences

class SessionManagement(context:Context) {

    companion object{
        const val KEY_SESSION_INFO = "SessionInfo"
        const val KEY_USER_NAME = "UserName"
        const val KEY_NICK_NAME = "NickName"
    }

    private val mSharedPreferences = AppPreferences(context)

    fun initializeSession(loginModelResponse: LoginModelResponse){
        mSharedPreferences.storeSessionInfo(KEY_SESSION_INFO, true)
        mSharedPreferences.storeString(KEY_USER_NAME, loginModelResponse.user.username.toString())
        mSharedPreferences.storeString(KEY_NICK_NAME, loginModelResponse.user.nickname.toString())
    }

    fun finishSession(){
        mSharedPreferences.storeSessionInfo(KEY_SESSION_INFO, false)
        mSharedPreferences.storeString(KEY_USER_NAME, "")
        mSharedPreferences.storeString(KEY_NICK_NAME, "")
    }

    fun getInfoSession():Boolean{
        return mSharedPreferences.getSessionInfo(KEY_SESSION_INFO)
    }
}