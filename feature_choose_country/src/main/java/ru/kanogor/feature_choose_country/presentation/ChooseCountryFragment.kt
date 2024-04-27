package ru.kanogor.feature_choose_country.presentation

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.google.android.material.chip.Chip
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.kanogor.core.base.BaseFragment
import ru.kanogor.core_ui.utils.getCurrentDate
import ru.kanogor.core_ui.utils.getYearFromString
import ru.kanogor.feature_choose_country.databinding.FragmentChooseCountryBinding
import ru.kanogor.feature_choose_country.domain.model.Ticket
import ru.kanogor.feature_choose_country.presentation.adapter.TicketsOffersInfoAdapter
import java.util.Calendar

class ChooseCountryFragment : BaseFragment<FragmentChooseCountryBinding>() {

    private val adapter by lazy { TicketsOffersInfoAdapter() }
    private val viewModel by viewModel<ChooseCountryViewModel>()
    private var tickets: List<Ticket>? = null

    override fun initBinding(inflater: LayoutInflater): FragmentChooseCountryBinding {
        return FragmentChooseCountryBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingObserver()
        dataObserver()
        initPlaces()
        initEditTextsButtons()
        onChipClick()
        setDataChip()
    }

    private fun loadingObserver() {
        viewModel.isLoading.onEach { isLoad ->
            if (isLoad) {
                binding.progressBar.visibility = View.VISIBLE
                binding.chooseCountryMainScreen.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                binding.chooseCountryMainScreen.visibility = View.VISIBLE
                adapter.submitList(tickets)
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
        binding.recyclerChooseCountry.adapter = adapter
    }

    private fun dataObserver() {
        with(viewModel) {
            data.onEach { data ->
                tickets = data as List<Ticket>?
            }.launchIn(viewLifecycleOwner.lifecycleScope)
        }
    }

    private fun initPlaces() {
        viewModel.placeTo.onEach { placeTo ->
            binding.chooseCountryToEdittext.setText(placeTo)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
        viewModel.placeFrom.onEach { placeFrom ->
            binding.chooseCountryFromEdittext.setText(placeFrom)
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initEditTextsButtons() {
        with(binding) {
            chooseCountryToEdittext.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_UP) {
                    if (event.rawX >= (chooseCountryToEdittext.right - chooseCountryToEdittext.compoundDrawables[2].bounds.width())) {
                        chooseCountryToEdittext.text = null
                        return@setOnTouchListener true
                    }
                }
                false
            }
            chooseCountryFromEdittext.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_UP) {
                    if (event.rawX >= (chooseCountryFromEdittext.right - chooseCountryFromEdittext.compoundDrawables[2].bounds.width())) {
                        val from = chooseCountryFromEdittext.text
                        val to = chooseCountryToEdittext.text
                        chooseCountryFromEdittext.text = to
                        chooseCountryToEdittext.text = from
                        return@setOnTouchListener true
                    }
                }
                false
            }
        }
    }

    private fun setDataChip() {
        binding.dataChip.text = getCurrentDate()
    }

    private fun onChipClick() {
        with(binding) {
            backChip.setOnClickListener {
                dateListener(backChip)
            }
            dataChip.setOnClickListener {
                dateListener(dataChip)
            }
        }
    }

    private fun dateListener(chip: Chip) {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)
        val listener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            val birthdayDate = "$year-${monthOfYear + 1}-$dayOfMonth"
            val date = getYearFromString(birthdayDate)
            chip.apply {
                text = date
            }
        }

        DatePickerDialog(requireContext(), listener, currentYear, currentMonth, currentDay).apply {
            datePicker.maxDate = System.currentTimeMillis()
        }.show()
    }

}