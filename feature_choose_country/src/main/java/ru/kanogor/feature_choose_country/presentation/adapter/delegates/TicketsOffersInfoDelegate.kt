package ru.kanogor.feature_choose_country.presentation.adapter.delegates

import android.view.LayoutInflater
import ru.kanogor.delegates.adapterDelegate
import ru.kanogor.feature_choose_country.R
import ru.kanogor.feature_choose_country.databinding.TicketInfoItemBinding
import ru.kanogor.feature_choose_country.domain.model.Ticket

fun ticketsOfferAdapterDelegate() =
    adapterDelegate<Ticket, Ticket, TicketInfoItemBinding>({ parent ->
        TicketInfoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        bind {
            with(binding) {
                when (item.num) {
                    0 -> colorImage.setImageResource(R.drawable.ic_red_circle)
                    1 -> colorImage.setImageResource(R.drawable.ic_blue_circle)
                    2 -> colorImage.setImageResource(R.drawable.ic_white_circle)
                }
                title.text = item.title
                subtitle.text =
                    item.timeRange.joinToString(separator = " ", limit = 6, truncated = "...")
                priceText.text = "${item.price.value} ₽   "
            }
        }
    }