package ru.kanogor.feature_watch_all_tickets.presentation.adapter.delegates

import android.view.LayoutInflater
import android.view.View
import ru.kanogor.core_ui.utils.convertDateToLong
import ru.kanogor.core_ui.utils.convertLongToTime
import ru.kanogor.core_ui.utils.getHourFromLongDate
import ru.kanogor.delegates.adapterDelegate
import ru.kanogor.feature_watch_all_tickets.databinding.FlightInfoItemBinding
import ru.kanogor.feature_watch_all_tickets.domain.model.FlightTicket


fun flightTicketAdapterDelegate() =
    adapterDelegate<FlightTicket, FlightTicket, FlightInfoItemBinding>({ parent ->
        FlightInfoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        bind {
            with(binding) {
                if (item.badge.isNullOrEmpty()) {
                    topCard.visibility = View.GONE
                } else topText.text = item.badge
                priceText.text = "${item.price.value} ₽"
                if (item.departure?.date != null && item.arrival?.date != null) {
                    val textFrom = getHourFromLongDate(item.departure!!.date)
                    val textTo = getHourFromLongDate(item.arrival!!.date)
                    flightTime.text = "$textFrom - $textTo"
                    val flightTimeLong =
                        convertDateToLong(item.arrival!!.date) - convertDateToLong(item.departure!!.date)
                    val flightTimeString = convertLongToTime(flightTimeLong)
                    if (item.hasTransfer == true) {
                        flightConditions.text = "$flightTimeString ч в пути/ Без пересадок"
                    } else flightConditions.text = "$flightTimeString ч в пути"
                }
                airFromCode.text = item.departure?.airport
                airToCode.text = item.arrival?.airport
            }
        }
    }