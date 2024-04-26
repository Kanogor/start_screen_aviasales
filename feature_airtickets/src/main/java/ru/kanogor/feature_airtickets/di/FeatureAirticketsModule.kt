package ru.kanogor.feature_airtickets.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kanogor.feature_airtickets.data.repository.AirticketsRepositoryImpl
import ru.kanogor.feature_airtickets.domain.repository.AirticketsRepository
import ru.kanogor.feature_airtickets.domain.use_case.GetAirticketsUseCase
import ru.kanogor.feature_airtickets.domain.use_case.impl.GetAirticketsUseCaseImpl
import ru.kanogor.feature_airtickets.presentation.firstpage.AirticketsViewModel

fun featureAirticketsModule() = module {

    single<AirticketsRepository> { AirticketsRepositoryImpl(api = get()) }

    single<GetAirticketsUseCase> { GetAirticketsUseCaseImpl(repository = get()) }

    viewModel {
        AirticketsViewModel(
            getAirticketsUseCase = get(),
            dispatcherWrapper = get(),
            localStorage = get(),
        )
    }
}

