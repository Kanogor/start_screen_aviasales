package ru.kanogor.feature_watch_all_tickets.domain.use_case

import ru.kanogor.feature_watch_all_tickets.domain.model.FlightTicket

interface GetFlightTicketsUseCase {

    suspend operator fun invoke(): List<FlightTicket>
}