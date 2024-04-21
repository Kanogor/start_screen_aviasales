package ru.kanogor.feature_airtickets.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import ru.kanogor.core.base.BaseFragment
import ru.kanogor.feature_airtickets.presentation.adapter.MusicOffersInfoAdapter
import ru.kanogor.feature_airtickets.presentation.state.MusicOffersState
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kanogor.feature_aviasales.databinding.FragmentAirticketsBinding

class AirticketsFragment : BaseFragment<FragmentAirticketsBinding>() {  //сделать MVVM и загрузку

    private val adapter by lazy { MusicOffersInfoAdapter() }
    private val viewModel by viewModel<AirticketsViewModel>()

    override fun initBinding(inflater: LayoutInflater): FragmentAirticketsBinding {
        return FragmentAirticketsBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
        flowObserver(viewModel.viewStates()) { state -> stateObserver(state) }
    }

    private fun stateObserver(state: MusicOffersState) {
        if (!state.isLoading) {
            adapter.submitList(state.musicOffers)
        }
    }
}