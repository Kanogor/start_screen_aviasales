package ru.kanogor.feature_watch_all_tickets.domain.model

import ru.kanogor.remote_api.api.dto.ArrivalDto
import ru.kanogor.remote_api.api.dto.DepartureDto
import ru.kanogor.remote_api.api.dto.FlightTicketDto
import ru.kanogor.remote_api.api.dto.FlightTicketsDto
import ru.kanogor.remote_api.api.dto.PriceDto

data class FlightTickets(
    val flightTickets: List<FlightTicket>
)

data class FlightTicket(
    val id: Int,
    val badge: String?,
    val price: Price,
    val departure: Departure?,
    val arrival: Arrival?,
    val hasTransfer: Boolean?,
)

data class Price(
    val value: Int
)

data class Arrival(
    val date: String,
    val airport: String
)

data class Departure(
    val date: String,
    val airport: String
)

fun FlightTicketsDto.toFlightTickets() = FlightTickets(
    flightTickets = flightTickets.map { it.toFlightTicket() })

fun FlightTicketDto.toFlightTicket() = FlightTicket(
    id = id,
    badge = badge,
    departure = departure?.toDeparture(),
    price = price.toPrice(),
    arrival = arrival?.toArrival(),
    hasTransfer = has_transfer
)

fun PriceDto.toPrice() = Price(
    value = value
)

fun ArrivalDto.toArrival() = Arrival(
    date = date,
    airport = airport
)

fun DepartureDto.toDeparture() = Departure(
    date = date,
    airport = airport
)