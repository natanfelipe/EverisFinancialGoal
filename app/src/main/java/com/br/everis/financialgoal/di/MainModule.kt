package com.br.everis.financialgoal.di

import com.br.everis.financialgoal.data.datasource.service.ImpApiService
import com.br.everis.financialgoal.data.datasource.worker.cadastro.ImpCadastroDataSource
import com.br.everis.financialgoal.data.datasource.worker.login.ImpLoginDataSource
import com.br.everis.financialgoal.repository.cadastro.ImpCadastroRepository
import com.br.everis.financialgoal.repository.login.ImpLoginRepository
import com.br.everis.financialgoal.viewmodel.cadastro.CadastroViewModel
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

    single<ImpLoginDataSource> {
        ImpLoginDataSource(apiService = get())
    }
        single<ImpLoginRepository>{
            ImpLoginRepository(dataSource = get())
        }

        viewModel<CadastroViewModel> {
            CadastroViewModel(
                repository = get()
            )
        }
}
