package ru.kanogor.remote_api.api

import retrofit2.http.GET
import ru.kanogor.remote_api.api.dto.MusicOffersDto

const val BASE_START = "uc?export=download&id="

interface Api {

    @GET(BASE_START + MUSIC_OFFERS)
    suspend fun getMusicOffers(): MusicOffersDto

    companion object {
        const val MUSIC_OFFERS = "1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav"
    }
}