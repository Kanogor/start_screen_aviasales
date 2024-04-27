package ru.kanogor.feature_choose_country.data.repository

import ru.kanogor.feature_choose_country.domain.model.Ticket
import ru.kanogor.feature_choose_country.domain.model.toTicketsOffers
import ru.kanogor.feature_choose_country.domain.repository.ChooseCountryRepository
import ru.kanogor.remote_api.api.Api

class ChooseCountryRepositoryImpl(
    private val api: Api
) : ChooseCountryRepository {

    override suspend fun getTickets(): List<Ticket> {
        return api.getTicketsOffers().toTicketsOffers().ticketsOffers
    }
}