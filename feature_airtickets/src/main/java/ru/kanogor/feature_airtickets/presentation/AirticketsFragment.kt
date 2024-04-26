package ru.kanogor.feature_airtickets.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kanogor.core.base.BaseFragment
import ru.kanogor.feature_airtickets.domain.model.MusicOffer
import ru.kanogor.feature_airtickets.presentation.adapter.MusicOffersInfoAdapter
import ru.kanogor.feature_aviasales.R
import ru.kanogor.feature_aviasales.databinding.FragmentAirticketsBinding

class AirticketsFragment : BaseFragment<FragmentAirticketsBinding>() {

    private val adapter by lazy { MusicOffersInfoAdapter() }
    private val viewModel by viewModel<AirticketsViewModel>()
    private var musicOffers: List<MusicOffer>? = null

    override fun initBinding(inflater: LayoutInflater): FragmentAirticketsBinding {
        return FragmentAirticketsBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingObserver()
        dataObserver()
        initButton()
        initPlaceFrom()
    }

    private fun initPlaceFrom() {
        binding.airticketsFromEdittext.doOnTextChanged { text, _, _, _ ->
            if (!text.isNullOrEmpty()) {
                viewModel.setPlaceFrom(place = text.toString())
            }
        }
    }

    private fun dataObserver() {
        with(viewModel) {
            data.onEach { data ->
                musicOffers = data as List<MusicOffer>?
            }.launchIn(viewLifecycleOwner.lifecycleScope)
            placeFrom.onEach { place ->
                if (!place.isNullOrEmpty()) {
                    binding.airticketsFromEdittext.setText(place)
                }
            }.launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    private fun loadingObserver() {
        viewModel.isLoading.onEach { isLoad ->
            if (isLoad) {
                binding.progressBar.visibility = View.VISIBLE
                binding.airticketsMainScreen.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                binding.airticketsMainScreen.visibility = View.VISIBLE
                adapter.submitList(musicOffers)
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
        binding.recycler.adapter = adapter
    }

    private fun initButton() {
        binding.airticketsToEdittext.setOnClickListener {
            configCollectionBottomDialog()
        }
    }

    private fun configCollectionBottomDialog() {
        val dialog = BottomSheetDialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_dialog_search)
        dialog.setCancelable(true)
        dialog.dismissWithAnimation
        val edittextTo = dialog.findViewById<AppCompatEditText>(R.id.airtickets_dialog_to_edittext)
        val edittextFrom =
            dialog.findViewById<AppCompatEditText>(R.id.airtickets_dialog_from_edittext)
        // продолжить заполнение


        dialog.show()
    }
}