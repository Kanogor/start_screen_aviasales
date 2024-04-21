package ru.kanogor.feature_airtickets.presentation.state

import ru.kanogor.feature_airtickets.domain.model.MusicOffer

data class MusicOffersState(
    val musicOffers: List<MusicOffer> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
