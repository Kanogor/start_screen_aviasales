package ru.kanogor.feature_bell.presentation

import android.view.LayoutInflater
import ru.kanogor.core.base.BaseFragment
import ru.kanogor.feature_aviasales.databinding.FragmentBellBinding

class BellFragment : BaseFragment<FragmentBellBinding>() {
    override fun initBinding(inflater: LayoutInflater): FragmentBellBinding {
        return FragmentBellBinding.inflate(inflater)
    }
}