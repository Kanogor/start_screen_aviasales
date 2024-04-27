package ru.kanogor.feature_choose_country.presentation.adapter

import ru.kanogor.delegates.ListDelegateAdapterTreeCount
import ru.kanogor.feature_choose_country.domain.model.Ticket
import ru.kanogor.feature_choose_country.presentation.adapter.delegates.ticketsOfferAdapterDelegate
import ru.kanogor.feature_choose_country.presentation.adapter.diff_util.TicketOffersDiffUtil

class TicketsOffersInfoAdapter: ListDelegateAdapterTreeCount<Ticket>(TicketOffersDiffUtil()){

    init {
        addDelegate(ticketsOfferAdapterDelegate())
    }
}