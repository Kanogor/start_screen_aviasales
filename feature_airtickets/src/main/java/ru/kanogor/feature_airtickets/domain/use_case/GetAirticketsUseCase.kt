package ru.kanogor.feature_airtickets.domain.use_case

import ru.kanogor.feature_airtickets.domain.model.MusicOffer

interface GetAirticketsUseCase {

    suspend operator fun invoke(): List<MusicOffer>
}