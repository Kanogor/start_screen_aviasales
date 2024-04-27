package ru.kanogor.feature_choose_country.domain.use_case

import ru.kanogor.feature_choose_country.domain.model.Ticket

interface GetTicketsUseCase {

    suspend operator fun invoke(): List<Ticket>
}