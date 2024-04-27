package ru.kanogor.remote_api.api

import retrofit2.http.GET
import ru.kanogor.remote_api.api.dto.FlightTicketsDto
import ru.kanogor.remote_api.api.dto.MusicOffersDto
import ru.kanogor.remote_api.api.dto.TicketsOffersDto

const val BASE_START = "uc?export=download&id="

interface Api {

    @GET(BASE_START + MUSIC_OFFERS)
    suspend fun getMusicOffers(): MusicOffersDto

    @GET(BASE_START + TICKETS_OFFERS)
    suspend fun getTicketsOffers(): TicketsOffersDto

    @GET(BASE_START + FLIGHT_TICKETS)
    suspend fun getFlightTickets(): FlightTicketsDto

    companion object {
        const val MUSIC_OFFERS = "1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav"
        const val TICKETS_OFFERS = "13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta"
        const val FLIGHT_TICKETS = "1HogOsz4hWkRwco4kud3isZHFQLUAwNBA"
    }
}