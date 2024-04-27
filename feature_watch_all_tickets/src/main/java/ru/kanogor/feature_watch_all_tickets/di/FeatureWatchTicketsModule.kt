package ru.kanogor.feature_watch_all_tickets.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.kanogor.feature_watch_all_tickets.data.repository.WatchTicketRepositoryImpl
import ru.kanogor.feature_watch_all_tickets.domain.repository.WatchTicketRepository
import ru.kanogor.feature_watch_all_tickets.domain.use_case.GetFlightTicketsUseCase
import ru.kanogor.feature_watch_all_tickets.domain.use_case.impl.GetFlightTicketsUseCaseImpl
import ru.kanogor.feature_watch_all_tickets.presentation.WatchTicketsViewModel

fun featureWatchTicketsModule() = module {

    single<WatchTicketRepository> { WatchTicketRepositoryImpl(api = get()) }

    single<GetFlightTicketsUseCase> { GetFlightTicketsUseCaseImpl(repository = get()) }

    viewModel {
        WatchTicketsViewModel(
            getFlightTicketsUseCase = get(),
            dispatcherWrapper = get(),
            localStorage = get()
        )
    }
}