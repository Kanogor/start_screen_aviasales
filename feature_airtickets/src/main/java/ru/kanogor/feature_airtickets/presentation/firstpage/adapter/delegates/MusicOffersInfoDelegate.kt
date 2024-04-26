package ru.kanogor.feature_airtickets.presentation.firstpage.adapter.delegates

import android.view.LayoutInflater
import ru.kanogor.delegates.adapterDelegate
import ru.kanogor.feature_airtickets.domain.model.MusicOffer
import ru.kanogor.feature_aviasales.R
import ru.kanogor.feature_aviasales.databinding.MusicOffersViewHolderBinding


fun musicOfferAdapterDelegate() =
    adapterDelegate<MusicOffer, MusicOffer, MusicOffersViewHolderBinding>({ parent ->
        MusicOffersViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }) {
        bind {
            with(binding) {
                when (item.id) {
                    1 -> musicOfferImage.setImageResource(R.drawable.die_antwood)
                    2 -> musicOfferImage.setImageResource(R.drawable.socrat_i_lera)
                    3 -> musicOfferImage.setImageResource(R.drawable.lomp)
                }
                musicOfferTitle.text = item.title
                musicOfferTown.text = item.town
                musicOfferPrice.text = "от ${item.price.value} ₽"
            }
        }
    }