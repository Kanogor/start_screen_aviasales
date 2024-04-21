package ru.kanogor.feature_profile.presentation

import android.view.LayoutInflater
import ru.kanogor.core.base.BaseFragment
import ru.kanogor.feature_aviasales.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun initBinding(inflater: LayoutInflater): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater)
    }
}