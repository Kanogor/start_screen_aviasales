package ru.kanogor.feature_airtickets.domain.repository

import ru.kanogor.feature_airtickets.domain.model.MusicOffer

interface AirticketsRepository {

    suspend fun getMusicOffers(): List<MusicOffer>
}