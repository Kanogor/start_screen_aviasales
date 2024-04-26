package ru.kanogor.feature_airtickets.presentation

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MotionEvent
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
import ru.kanogor.feature_airtickets.presentation.viewgroups.HintIconItem
import ru.kanogor.feature_airtickets.presentation.viewgroups.PopularPlaceButton
import ru.kanogor.feature_aviasales.R
import ru.kanogor.feature_aviasales.databinding.FragmentAirticketsBinding

class AirticketsFragment : BaseFragment<FragmentAirticketsBinding>() {

    private val adapter by lazy { MusicOffersInfoAdapter() }
    private val viewModel by viewModel<AirticketsViewModel>()
    private var musicOffers: List<MusicOffer>? = null
    private var fromText: String? = null

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
                    fromText = place
                    binding.airticketsFromEdittext.setText(fromText)
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

    @SuppressLint("ClickableViewAccessibility")
    private fun configCollectionBottomDialog() {
        val dialog = BottomSheetDialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottom_dialog_search)
        val behavior = dialog.behavior
        behavior.peekHeight = Resources.getSystem().displayMetrics.heightPixels
        dialog.setCancelable(true)
        dialog.dismissWithAnimation
        val edittextFrom =
            dialog.findViewById<AppCompatEditText>(R.id.airtickets_dialog_from_edittext)
        edittextFrom?.setText(fromText)
        val edittextTo = dialog.findViewById<AppCompatEditText>(R.id.airtickets_dialog_to_edittext)
        edittextTo?.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= (edittextTo.right - edittextTo.compoundDrawables[2].bounds.width())) {
                    edittextTo.text = null
                    return@setOnTouchListener true
                }
            }
            false
        }
        edittextTo?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (!s.isNullOrEmpty()) {
                    //       findNavController().navigate()
                }
            }
        })

        fun setHint(item: HintIconItem?, icon: Int, subTitle: String, onClick: () -> Unit) {
            item?.setIcon(icon)
            item?.setSubTitle(subTitle)
            item?.onClick {
                onClick.invoke()
            }
        }

        val hintFirst = dialog.findViewById<HintIconItem>(R.id.first_hint_icon)
        setHint(item = hintFirst,
            icon = R.drawable.first_hint_ic,
            subTitle = getString(R.string.first_hint_text),
            onClick = {
                dialog.cancel()
            })
        val hintSecond = dialog.findViewById<HintIconItem>(R.id.second_hint_icon)
        setHint(item = hintSecond,
            icon = R.drawable.second_hint_ic,
            subTitle = getString(R.string.second_hint_text),
            onClick = {
                edittextTo?.setText(getString(R.string.second_hint_text))
            })
        val hintThird = dialog.findViewById<HintIconItem>(R.id.third_hint_icon)
        setHint(item = hintThird,
            icon = R.drawable.third_hint_ic,
            subTitle = getString(R.string.third_hint_text),
            onClick = {
                dialog.cancel()
            })
        val hintFourth = dialog.findViewById<HintIconItem>(R.id.fourth_hint_icon)
        setHint(item = hintFourth,
            icon = R.drawable.fourth_hint_ic,
            subTitle = getString(R.string.fourth_hint_text),
            onClick = {
                dialog.cancel()
            })

        fun setPopPlace(
            item: PopularPlaceButton?,
            icon: Int,
            title: String,
            onClick: () -> Unit
        ) {
            item?.setIcon(icon)
            item?.setTitle(title)
            item?.onClick {
                onClick.invoke()
            }
        }

        val istanbulPlace = dialog.findViewById<PopularPlaceButton>(R.id.pop_place_istanbul)
        setPopPlace(
            item = istanbulPlace,
            icon = R.drawable.istanbul_ic,
            title = getString(R.string.istanbul_text),
            onClick = {
                edittextTo?.setText(getString(R.string.istanbul_text))
            }
        )
        val sochiPlace = dialog.findViewById<PopularPlaceButton>(R.id.pop_place_sochi)
        setPopPlace(
            item = sochiPlace,
            icon = R.drawable.sochi_ic,
            title = getString(R.string.sochi_text),
            onClick = {
                edittextTo?.setText(getString(R.string.sochi_text))
            }
        )
        val phuketPlace = dialog.findViewById<PopularPlaceButton>(R.id.pop_place_phuket)
        setPopPlace(
            item = phuketPlace,
            icon = R.drawable.phuket_ic,
            title = getString(R.string.phuket_text),
            onClick = {
                edittextTo?.setText(getString(R.string.phuket_text))
            }
        )
        dialog.show()
    }
}