package com.br.everis.financialgoal.repository.recovery

import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelRequest
import com.br.everis.financialgoal.data.datarecoverysource.recovery.RecoveryResult

interface RecoveryRepository {

    fun recoveryRepository(
        recoveryResultCallback: (result: RecoveryResult) -> Unit,
        recovery: RecoveryModelRequest
    )

}