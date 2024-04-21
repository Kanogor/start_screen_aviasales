package ru.kanogor.feature_airtickets.presentation.adapter

import ru.kanogor.delegates.ListDelegateAdapter
import ru.kanogor.feature_airtickets.domain.model.MusicOffer
import ru.kanogor.feature_airtickets.presentation.adapter.delegates.musicOfferAdapterDelegate
import ru.kanogor.feature_airtickets.presentation.adapter.diff_util.MusicOffersDiffUtil

class MusicOffersInfoAdapter: ListDelegateAdapter<MusicOffer>(MusicOffersDiffUtil()){

    init {
        addDelegate(musicOfferAdapterDelegate())
    }
}