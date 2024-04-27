package ru.kanogor.feature_choose_country.domain.use_case.impl

import ru.kanogor.feature_choose_country.domain.model.Ticket
import ru.kanogor.feature_choose_country.domain.repository.ChooseCountryRepository
import ru.kanogor.feature_choose_country.domain.use_case.GetTicketsUseCase

class GetTicketsUseCaseImpl(
    private val repository: ChooseCountryRepository
) : GetTicketsUseCase {

    override suspend fun invoke(): List<Ticket> {
        return repository.getTickets()
    }
}