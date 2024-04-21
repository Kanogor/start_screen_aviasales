package ru.kanogor.feature_airtickets.data.repository

import ru.kanogor.feature_airtickets.domain.model.MusicOffer
import ru.kanogor.feature_airtickets.domain.model.toMusicOffers
import ru.kanogor.feature_airtickets.domain.repository.AirticketsRepository
import ru.kanogor.remote_api.api.Api

class AirticketsRepositoryImpl(
    private val api: Api
) : AirticketsRepository {

    override suspend fun getMusicOffers(): List<MusicOffer> {
        return api.getMusicOffers().toMusicOffers().offers
    }
}