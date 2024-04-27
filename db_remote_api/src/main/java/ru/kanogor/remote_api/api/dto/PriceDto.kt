package ru.kanogor.remote_api.api.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class PriceDto(
    @Json(name = "value")
    val value: Int,
)