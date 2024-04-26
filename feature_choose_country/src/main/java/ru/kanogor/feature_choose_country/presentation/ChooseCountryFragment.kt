package ru.kanogor.feature_choose_country.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kanogor.core.base.BaseFragment
import ru.kanogor.feature_choose_country.databinding.FragmentChooseCountryBinding

class ChooseCountryFragment: BaseFragment<FragmentChooseCountryBinding>() {

 //   private val adapter by lazy { MusicOffersInfoAdapter() }
    private val viewModel by viewModel<ChooseCountryViewModel>()

    override fun initBinding(inflater: LayoutInflater): FragmentChooseCountryBinding {
        return FragmentChooseCountryBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}