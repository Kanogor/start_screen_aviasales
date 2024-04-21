package ru.kanogor.feature_airtickets.domain.model

import ru.kanogor.remote_api.api.dto.MusicOfferDto
import ru.kanogor.remote_api.api.dto.MusicOffersDto
import ru.kanogor.remote_api.api.dto.PriceDto

data class MusicOffers(
    val offers: List<MusicOffer>
)

data class MusicOffer(
    val id: Int,
    val title: String,
    val town: String,
    val price: Price
)

data class Price(
    val value: Int
)

fun MusicOffersDto.toMusicOffers() = MusicOffers(
    offers = offers.map { it.toMusicOffer() }
)

fun MusicOfferDto.toMusicOffer() = MusicOffer(
    id = id,
    title = title,
    town = town,
    price = price.toPrice()
)

fun PriceDto.toPrice() = Price(
    value = value
)

