package ru.kanogor.feature_choose_country.domain.model

import ru.kanogor.remote_api.api.dto.PriceDto
import ru.kanogor.remote_api.api.dto.TicketDto
import ru.kanogor.remote_api.api.dto.TicketsOffersDto

data class TicketsOffers(
    val ticketsOffers: List<Ticket>
)

data class Ticket(
    val num: Int,
    val id: Int,
    val title: String,
    val timeRange: List<String>,
    val price: Price
)

data class Price(
    val value: Int
)

fun TicketsOffersDto.toTicketsOffers() = TicketsOffers(
    ticketsOffers = ticketsOffers.mapIndexed { index, ticketDto ->
        ticketDto.toTicket(index)

    }
)

fun TicketDto.toTicket(index: Int) = Ticket(
    num = index,
    id = id,
    title = title,
    timeRange = timeRange,
    price = price.toPrice()
)

fun PriceDto.toPrice() = Price(
    value = value
)

