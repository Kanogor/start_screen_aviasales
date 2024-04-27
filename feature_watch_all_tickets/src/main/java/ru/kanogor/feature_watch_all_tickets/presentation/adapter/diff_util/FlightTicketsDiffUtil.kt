package ru.kanogor.feature_watch_all_tickets.presentation.adapter.diff_util

import androidx.recyclerview.widget.DiffUtil
import ru.kanogor.feature_watch_all_tickets.domain.model.FlightTicket

class MusicOffersDiffUtil: DiffUtil.ItemCallback<FlightTicket>() {

    override fun areItemsTheSame(oldItem: FlightTicket, newItem: FlightTicket): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: FlightTicket, newItem: FlightTicket): Boolean {
        return oldItem == newItem

    }
}