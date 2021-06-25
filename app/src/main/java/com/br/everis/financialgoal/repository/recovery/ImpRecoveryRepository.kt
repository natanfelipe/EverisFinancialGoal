package com.br.everis.financialgoal.repository.recovery

import com.br.everis.financialgoal.data.datarecoverysource.model.RecoveryModelRequest
import com.br.everis.financialgoal.data.datarecoverysource.recovery.ImpRecoveryDataSource
import com.br.everis.financialgoal.data.datarecoverysource.recovery.RecoveryResult
import com.br.everis.financialgoal.data.datasource.worker.cadastro.ImpCadastroDataSource

class ImpRecoveryRepository (
    private val dataRecoverySource: ImpRecoveryDataSource
): RecoveryRepository {

    override fun recoveryRepository(
        recoveryResultCallback: (result: RecoveryResult) -> Unit,
        recovery: RecoveryModelRequest
    ) {
        dataRecoverySource.recoveryDataSource(recoveryResultCallback,recovery)
    }
}