package ru.kanogor.feature_watch_all_tickets.domain.repository

import ru.kanogor.feature_watch_all_tickets.domain.model.FlightTicket

interface WatchTicketRepository {

    suspend fun getFlightTickets(): List<FlightTicket>
}