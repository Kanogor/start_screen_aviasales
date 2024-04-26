package ru.kanogor.feature_airtickets.presentation.firstpage.adapter.diff_util

import androidx.recyclerview.widget.DiffUtil
import ru.kanogor.feature_airtickets.domain.model.MusicOffer

class MusicOffersDiffUtil: DiffUtil.ItemCallback<MusicOffer>() {

    override fun areItemsTheSame(oldItem: MusicOffer, newItem: MusicOffer): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MusicOffer, newItem: MusicOffer): Boolean {
        return oldItem == newItem

    }
}