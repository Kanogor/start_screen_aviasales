package ru.kanogor.feature_watch_all_tickets.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.kanogor.core.base.BaseViewModel
import ru.kanogor.core.wrapper.DispatcherWrapper
import ru.kanogor.feature_watch_all_tickets.domain.use_case.GetFlightTicketsUseCase
import ru.kanogor.remote_api.sharedpref.LocalStorage

class WatchTicketsViewModel(
    private val getFlightTicketsUseCase: GetFlightTicketsUseCase,
    private val dispatcherWrapper: DispatcherWrapper,
    private val localStorage: LocalStorage
) : BaseViewModel() {

    private val _placeFrom = MutableStateFlow<String?>(null)
    val placeFrom = _placeFrom.asStateFlow()

    private val _placeTo = MutableStateFlow<String?>(null)
    val placeTo = _placeTo.asStateFlow()

    private val _dateDeparture = MutableStateFlow<String?>(null)
    val dateDeparture = _dateDeparture.asStateFlow()

    init {
        getFlightTickets()
        getPlaceFrom()
        getPlaceTo()
        getDate()
    }

    private fun getPlaceFrom() {
        _placeFrom.value = localStorage.placeFrom
    }

    private fun getPlaceTo() {
        _placeTo.value = localStorage.placeTo
    }

    private fun getDate() {
        _dateDeparture.value = localStorage.dateDeparture
    }

    private fun getFlightTickets() {
        viewModelScope.launch(dispatcherWrapper.io) {
            _isLoading.value = true
            kotlin.runCatching {
                getFlightTicketsUseCase.invoke()
            }.fold(
                onSuccess = {
                    _data.value = it
                },
                onFailure = {
                    Log.d("StateResult", "error = $it")
                }
            )
            _isLoading.value = false
        }
    }
}