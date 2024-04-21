package ru.kanogor.feature_airtickets.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kanogor.core.base.BaseFragment
import ru.kanogor.feature_airtickets.presentation.adapter.MusicOffersInfoAdapter
import ru.kanogor.feature_airtickets.presentation.state.MusicOffersState
import ru.kanogor.feature_aviasales.R
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
        binding.airticketsToEdittext.setOnClickListener {
            configCollectionBottomDialog()
        }
    }

    private fun stateObserver(state: MusicOffersState) {
        if (!state.isLoading) {
            adapter.submitList(state.musicOffers)
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