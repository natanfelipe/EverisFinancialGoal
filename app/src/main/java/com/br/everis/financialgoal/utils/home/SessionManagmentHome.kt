package com.br.everis.financialgoal.utils.home

import android.content.Context
import com.br.everis.financialgoal.utils.preferences.AppPreferences
import com.br.everis.financialgoal.utils.sessionManagment.SessionManagement

class SessionManagmentHome(context: Context) {

    companion object {
        const val KEY_FLAG = "flagFragment"
    }

    private val mSharedPreferences = AppPreferences(context)

    fun InitializeFlagFragment(fragment:String){
        mSharedPreferences.storeString(KEY_FLAG, fragment)
    }

    fun FinishFlagFragment(){
        mSharedPreferences.storeString(KEY_FLAG, "")
    }

    fun getFlagFragment():String{
        return mSharedPreferences.getString(KEY_FLAG)
    }
}