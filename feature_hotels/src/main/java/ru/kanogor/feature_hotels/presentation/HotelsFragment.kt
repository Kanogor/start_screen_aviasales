package ru.kanogor.feature_hotels.presentation

import android.view.LayoutInflater
import ru.kanogor.core.base.BaseFragment
import ru.kanogor.feature_aviasales.databinding.FragmentHotelsBinding

class HotelsFragment : BaseFragment<FragmentHotelsBinding>() {

    override fun initBinding(inflater: LayoutInflater): FragmentHotelsBinding {
        return FragmentHotelsBinding.inflate(inflater)
    }
}