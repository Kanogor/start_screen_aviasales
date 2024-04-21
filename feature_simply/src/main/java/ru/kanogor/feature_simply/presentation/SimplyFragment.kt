package ru.kanogor.feature_simply.presentation

import android.view.LayoutInflater
import ru.kanogor.core.base.BaseFragment
import ru.kanogor.feature_aviasales.databinding.FragmentSimplyBinding

class SimplyFragment : BaseFragment<FragmentSimplyBinding>() {

    override fun initBinding(inflater: LayoutInflater): FragmentSimplyBinding {
        return FragmentSimplyBinding.inflate(inflater)
    }
}