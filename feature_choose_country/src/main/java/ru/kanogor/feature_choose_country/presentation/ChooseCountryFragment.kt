package ru.kanogor.feature_choose_country.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kanogor.core.base.BaseFragment
import ru.kanogor.feature_choose_country.R
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