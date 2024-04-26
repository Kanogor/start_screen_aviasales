package ru.kanogor.feature_choose_country.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kanogor.feature_choose_country.presentation.ChooseCountryViewModel

fun featureChooseCountryModule() = module {

    viewModel {
        ChooseCountryViewModel(
            localStorage = get(),
        )
    }
}