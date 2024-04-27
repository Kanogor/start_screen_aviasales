package ru.kanogor.feature_watch_all_tickets.domain.use_case.impl

import ru.kanogor.feature_watch_all_tickets.domain.model.FlightTicket
import ru.kanogor.feature_watch_all_tickets.domain.repository.WatchTicketRepository
import ru.kanogor.feature_watch_all_tickets.domain.use_case.GetFlightTicketsUseCase

class GetFlightTicketsUseCaseImpl(
    private val repository: WatchTicketRepository
) : GetFlightTicketsUseCase {

    override suspend fun invoke(): List<FlightTicket> {
        return repository.getFlightTickets()
    }
}