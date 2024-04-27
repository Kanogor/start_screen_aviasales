package ru.kanogor.feature_watch_all_tickets.presentation.adapter

import ru.kanogor.delegates.ListDelegateAdapter
import ru.kanogor.feature_watch_all_tickets.presentation.adapter.delegates.flightTicketAdapterDelegate
import ru.kanogor.feature_watch_all_tickets.domain.model.FlightTicket
import ru.kanogor.feature_watch_all_tickets.presentation.adapter.diff_util.MusicOffersDiffUtil

class FlightTicketsInfoAdapter: ListDelegateAdapter<FlightTicket>(MusicOffersDiffUtil()){

    init {
        addDelegate(flightTicketAdapterDelegate())
    }
}