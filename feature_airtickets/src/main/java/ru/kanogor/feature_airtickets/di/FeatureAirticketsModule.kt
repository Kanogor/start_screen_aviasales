package ru.kanogor.feature_airtickets.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidApplication
import ru.kanogor.feature_airtickets.data.repository.AirticketsRepositoryImpl
import ru.kanogor.feature_airtickets.domain.repository.AirticketsRepository
import ru.kanogor.feature_airtickets.domain.use_case.GetAirticketsUseCase
import ru.kanogor.feature_airtickets.domain.use_case.impl.GetAirticketsUseCaseImpl
import ru.kanogor.feature_airtickets.presentation.AirticketsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kanogor.feature_airtickets.data.PreferencesManager
import ru.kanogor.feature_airtickets.domain.model.LocalStorage

fun featureAirticketsModule() = module {

    single<AirticketsRepository> { AirticketsRepositoryImpl(api = get()) }

    single<GetAirticketsUseCase> { GetAirticketsUseCaseImpl(repository = get()) }

    single { provideAppPreference(androidApplication()) }

    viewModel {
        AirticketsViewModel(
            getAirticketsUseCase = get(),
            dispatcherWrapper = get(),
            localStorage = get(),
        )
    }
}

private fun provideAppPreference(application: Application): LocalStorage {
    val myPref = application.applicationContext.getSharedPreferences(
        "SharedPref_base",
        Context.MODE_PRIVATE
    )
    return PreferencesManager(myPref)
}