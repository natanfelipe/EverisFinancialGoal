package com.br.everis.financialgoal.utils.cadastro

import android.content.Context
import android.widget.Toast

object setToastMessage {
    fun setMessage(context:Context,message:String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }
}