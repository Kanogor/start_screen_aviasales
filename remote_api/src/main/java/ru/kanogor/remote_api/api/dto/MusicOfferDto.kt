package ru.kanogor.remote_api.api.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MusicOffersDto(
    @Json(name = "offers")
    val offers: List<MusicOfferDto>
)

@JsonClass(generateAdapter = true)
data class MusicOfferDto(
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "town")
    val town: String,
    @Json(name = "price")
    val price: PriceDto
)

@JsonClass(generateAdapter = true)
data class PriceDto(
    @Json(name = "value")
    val value: Int,
)
