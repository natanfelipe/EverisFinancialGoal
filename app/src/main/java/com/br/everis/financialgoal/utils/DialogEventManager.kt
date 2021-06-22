package com.br.everis.financialgoal.utils

class DialogEventManager {

    companion object {
        var TITLE = ""
        var MESSAGE = ""
        const val POSITIVE_BUTTON = "OK"
    }

    fun setTitleAndMessage(event: Int) {

        when (event) {
            1 -> {
                TITLE = "E-mail inválido"
                MESSAGE = "forneça um endereço de e-mail válido"
            }
            2 -> {
                TITLE = "Nome/Apelido inválido"
                MESSAGE = "O nome/apelido deve ter pelo menos 1 carácter"
            }
            3 -> {
                TITLE = "Senha inválida"
                MESSAGE = "a senha deve ter pelo menos 8 dígitos"
            }
        }

    }

}