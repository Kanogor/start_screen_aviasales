package ru.kanogor.feature_watch_all_tickets.data.repository

import ru.kanogor.feature_watch_all_tickets.domain.model.FlightTicket
import ru.kanogor.feature_watch_all_tickets.domain.model.toFlightTickets
import ru.kanogor.feature_watch_all_tickets.domain.repository.WatchTicketRepository
import ru.kanogor.remote_api.api.Api

class WatchTicketRepositoryImpl(
    private val api: Api
) : WatchTicketRepository {

    override suspend fun getFlightTickets(): List<FlightTicket> {
        return api.getFlightTickets().toFlightTickets().flightTickets
    }
}