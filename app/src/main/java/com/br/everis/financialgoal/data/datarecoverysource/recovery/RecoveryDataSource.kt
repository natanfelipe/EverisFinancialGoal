package com.br.everis.financialgoal.data.datarecoverysource.recovery

import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelRequest

interface RecoveryDataSource {
    fun recoveryDataSource(
recoveryResultCallback: (result: RecoveryResult) -> Unit,
recovery:RecoveryModelRequest)
}
