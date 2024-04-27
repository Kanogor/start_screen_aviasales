package ru.kanogor.feature_choose_country.presentation.adapter.diff_util

import androidx.recyclerview.widget.DiffUtil
import ru.kanogor.feature_choose_country.domain.model.Ticket

class TicketOffersDiffUtil: DiffUtil.ItemCallback<Ticket>() {

    override fun areItemsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Ticket, newItem: Ticket): Boolean {
        return oldItem == newItem

    }
}