package ru.kanogor.remote_api.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TicketsOffersDto(
    @Json(name = "tickets_offers")
    val ticketsOffers: List<TicketDto>
)

@JsonClass(generateAdapter = true)
data class TicketDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "time_range")
    val timeRange: List<String>,
    @Json(name = "price")
    val price: PriceDto
)

