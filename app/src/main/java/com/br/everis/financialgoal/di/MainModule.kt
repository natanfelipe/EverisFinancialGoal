package com.br.everis.financialgoal.di

import com.br.everis.financialgoal.data.yearlysource.yearlydatasource.ImpYearlyDataSource
import com.br.everis.financialgoal.data.datarecoverysource.recovery.ImpRecoveryDataSource
import com.br.everis.financialgoal.data.datasource.service.ImpApiService
import com.br.everis.financialgoal.data.datasource.worker.cadastro.ImpCadastroDataSource
import com.br.everis.financialgoal.data.datasource.worker.login.ImpLoginDataSource
import com.br.everis.financialgoal.repository.cadastro.ImpCadastroRepository
import com.br.everis.financialgoal.repository.yearly.YearlyRepository
import com.br.everis.financialgoal.repository.yearly.ImpYearlyRepository
import com.br.everis.financialgoal.repository.recovery.ImpRecoveryRepository
import com.br.everis.financialgoal.viewmodel.yearly.YearlyViewModel
import com.br.everis.financialgoal.viewmodel.cadastro.CadastroViewModel
import com.br.everis.financialgoal.repository.cadastro.ImpLoginRepository
import com.br.everis.financialgoal.viewmodel.login.LoginViewModel
import com.br.everis.financialgoal.viewmodel.recovery.RecoveryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory<ImpApiService> { ImpApiService() }

    factory<ImpCadastroDataSource> {
        ImpCadastroDataSource(
            apiService = get()
        )
    }

    factory<ImpCadastroRepository> {
        ImpCadastroRepository(
            dataSource = get()
        )
    }

    viewModel<CadastroViewModel> {
        CadastroViewModel(
            repository = get()
        )
    }

    single<ImpLoginDataSource> {
        ImpLoginDataSource(apiService = get())
    }

    single<ImpLoginRepository> {
        ImpLoginRepository(dataSource = get())
    }

    viewModel<LoginViewModel> {
        LoginViewModel(repository = get())
    }
    factory<ImpRecoveryDataSource> {
        ImpRecoveryDataSource(
            apiService = get()
        )
    }
    factory<ImpRecoveryRepository> {
        ImpRecoveryRepository(
            dataRecoverySource = get()
        )
    }
    viewModel<RecoveryViewModel> {
        RecoveryViewModel(
            repository = get()
        )
    }

    factory<ImpYearlyDataSource>{
        ImpYearlyDataSource(
            apiService = get()
        )
    }
    factory<YearlyRepository>{
        ImpYearlyRepository(
            dataSource = get()
        )
    }
    viewModel<YearlyViewModel>{
        YearlyViewModel(
            repository = get()
        )
    }
}
