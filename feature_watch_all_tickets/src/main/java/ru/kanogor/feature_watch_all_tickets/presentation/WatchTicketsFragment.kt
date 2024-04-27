package ru.kanogor.feature_watch_all_tickets.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kanogor.core.base.BaseFragment
import ru.kanogor.feature_watch_all_tickets.R
import ru.kanogor.feature_watch_all_tickets.databinding.FragmentWatchTicketsBinding
import ru.kanogor.feature_watch_all_tickets.domain.model.FlightTicket
import ru.kanogor.feature_watch_all_tickets.presentation.adapter.FlightTicketsInfoAdapter

class WatchTicketsFragment : BaseFragment<FragmentWatchTicketsBinding>() {

    private val adapter by lazy { FlightTicketsInfoAdapter() }
    private val viewModel by viewModel<WatchTicketsViewModel>()
    private var tickets: List<FlightTicket>? = null
    private var placeFromText: String? = null
    private var placeToText: String? = null

    override fun initBinding(inflater: LayoutInflater): FragmentWatchTicketsBinding {
        return FragmentWatchTicketsBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInfo()
        dataObserver()
        loadingObserver()
        initNavigation()
    }

    private fun initInfo() {
        with(viewModel) {
            placeFrom.onEach {
                placeFromText = it
            }.launchIn(viewLifecycleOwner.lifecycleScope)

            placeTo.onEach {
                placeToText = it
            }.launchIn(viewLifecycleOwner.lifecycleScope)
            binding.placeText.text = getString(R.string.place_text, placeFromText, placeToText)

            dateDeparture.onEach {
                binding.passDateText.text = "$it, 1 пассажир"
            }.launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    private fun loadingObserver() {
        viewModel.isLoading.onEach { isLoad ->
            if (isLoad) {
                binding.progressBar.visibility = View.VISIBLE
                binding.watchTickMainScreen.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                binding.watchTickMainScreen.visibility = View.VISIBLE
                adapter.submitList(tickets)
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
        binding.recyclerWatchTickets.adapter = adapter
    }

    private fun dataObserver() {
        with(viewModel) {
            data.onEach { data ->
                tickets = data as List<FlightTicket>?
            }.launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    private fun initNavigation() {
        with(binding) {
            watchTicketsBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

}