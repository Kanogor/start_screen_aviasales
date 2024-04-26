package ru.kanogor.feature_airtickets.presentation

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.kanogor.core.base.BaseViewModel
import ru.kanogor.core.wrapper.DispatcherWrapper
import ru.kanogor.feature_airtickets.domain.model.LocalStorage
import ru.kanogor.feature_airtickets.domain.use_case.GetAirticketsUseCase

class AirticketsViewModel(
    private val getAirticketsUseCase: GetAirticketsUseCase,
    private val dispatcherWrapper: DispatcherWrapper,
    private val localStorage: LocalStorage
) : BaseViewModel() {

    private val _placeFrom = MutableStateFlow<String?>(null)
    val placeFrom = _placeFrom.asStateFlow()

    init {
        getMusicOffers()
        getPlaceFrom()
    }

    private fun getPlaceFrom() {
        _placeFrom.value = localStorage.placeFrom
    }

    fun setPlaceFrom(place: String) {
        localStorage.placeFrom = place
    }

    private fun getMusicOffers() {
        viewModelScope.launch(dispatcherWrapper.io) {
            _isLoading.value = true
            kotlin.runCatching {
                getAirticketsUseCase.invoke()
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