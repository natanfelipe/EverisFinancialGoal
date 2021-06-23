package com.br.everis.financialgoal.di

import com.br.everis.financialgoal.data.datasource.service.ImpApiService
import com.br.everis.financialgoal.data.datasource.worker.cadastro.ImpCadastroDataSource
import com.br.everis.financialgoal.data.datasource.worker.login.ImpLoginDataSource
import com.br.everis.financialgoal.repository.cadastro.ImpCadastroRepository
import com.br.everis.financialgoal.repository.cadastro.ImpLoginRepository
import com.br.everis.financialgoal.viewmodel.cadastro.CadastroViewModel
import com.br.everis.financialgoal.viewmodel.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory<ImpApiService> { ImpApiService() }

    single<ImpCadastroDataSource> {
        ImpCadastroDataSource(
            apiService = get()
        )
    }

    single<ImpCadastroRepository> {
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

    single<ImpLoginRepository>{
        ImpLoginRepository(dataSource = get())
    }

    viewModel<LoginViewModel>{
        LoginViewModel(repository = get())
    }
}
