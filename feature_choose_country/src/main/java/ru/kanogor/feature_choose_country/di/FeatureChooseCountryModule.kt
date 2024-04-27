package ru.kanogor.feature_choose_country.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kanogor.feature_choose_country.data.repository.ChooseCountryRepositoryImpl
import ru.kanogor.feature_choose_country.domain.repository.ChooseCountryRepository
import ru.kanogor.feature_choose_country.domain.use_case.GetTicketsUseCase
import ru.kanogor.feature_choose_country.domain.use_case.impl.GetTicketsUseCaseImpl
import ru.kanogor.feature_choose_country.presentation.ChooseCountryViewModel

fun featureChooseCountryModule() = module {

    single<ChooseCountryRepository> { ChooseCountryRepositoryImpl(api = get()) }

    single<GetTicketsUseCase> { GetTicketsUseCaseImpl(repository = get()) }

    viewModel {
        ChooseCountryViewModel(
            getTicketsUseCase = get(),
            dispatcherWrapper = get(),
            localStorage = get(),
        )
    }
}