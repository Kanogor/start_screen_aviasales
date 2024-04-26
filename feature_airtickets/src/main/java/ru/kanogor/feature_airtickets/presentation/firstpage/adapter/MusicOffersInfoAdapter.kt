package ru.kanogor.feature_airtickets.presentation.firstpage.adapter

import ru.kanogor.delegates.ListDelegateAdapter
import ru.kanogor.feature_airtickets.domain.model.MusicOffer
import ru.kanogor.feature_airtickets.presentation.firstpage.adapter.delegates.musicOfferAdapterDelegate
import ru.kanogor.feature_airtickets.presentation.firstpage.adapter.diff_util.MusicOffersDiffUtil

class MusicOffersInfoAdapter: ListDelegateAdapter<MusicOffer>(MusicOffersDiffUtil()){

    init {
        addDelegate(musicOfferAdapterDelegate())
    }
}