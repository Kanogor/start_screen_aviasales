package ru.kanogor.remote_api.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlightTicketsDto(
    @Json(name = "tickets")
    val flightTickets: List<FlightTicketDto>
)

@JsonClass(generateAdapter = true)
data class FlightTicketDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "badge")
    val badge: String?,
    @Json(name = "price")
    val price: PriceDto,
    @Json(name = "departure")
    val departure: DepartureDto?,
    @Json(name = "arrival")
    val arrival: ArrivalDto?,
    @Json(name = "has_transfer")
    val has_transfer: Boolean?,
)

@JsonClass(generateAdapter = true)
data class ArrivalDto(
    @Json(name = "date")
    val date: String,
    @Json(name = "airport")
    val airport: String
)

@JsonClass(generateAdapter = true)
data class DepartureDto(
    @Json(name = "date")
    val date: String,
    @Json(name = "airport")
    val airport: String
)

