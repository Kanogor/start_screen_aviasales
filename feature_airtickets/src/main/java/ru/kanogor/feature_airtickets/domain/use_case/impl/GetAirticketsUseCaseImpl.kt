package ru.kanogor.feature_airtickets.domain.use_case.impl

import ru.kanogor.feature_airtickets.domain.model.MusicOffer
import ru.kanogor.feature_airtickets.domain.repository.AirticketsRepository
import ru.kanogor.feature_airtickets.domain.use_case.GetAirticketsUseCase

class GetAirticketsUseCaseImpl(
    private val repository: AirticketsRepository
): GetAirticketsUseCase {

    override suspend fun invoke(): List<MusicOffer> {
        return repository.getMusicOffers()
    }
}