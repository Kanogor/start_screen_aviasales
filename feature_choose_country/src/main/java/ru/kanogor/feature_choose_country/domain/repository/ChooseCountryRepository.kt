package ru.kanogor.feature_choose_country.domain.repository

import ru.kanogor.feature_choose_country.domain.model.Ticket

interface ChooseCountryRepository {

    suspend fun getTickets(): List<Ticket>
}