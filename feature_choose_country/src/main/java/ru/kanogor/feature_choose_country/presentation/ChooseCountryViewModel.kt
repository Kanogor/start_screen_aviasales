package ru.kanogor.feature_choose_country.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.kanogor.core.base.BaseViewModel
import ru.kanogor.remote_api.sharedpref.LocalStorage

class ChooseCountryViewModel(
    private val localStorage: LocalStorage
) : BaseViewModel() {

    private val _placeFrom = MutableStateFlow<String?>(null)
    val placeFrom = _placeFrom.asStateFlow()

    private val _placeTo = MutableStateFlow<String?>(null)
    val placeTo = _placeTo.asStateFlow()

    init {
//        getMusicOffers()
        getPlaceFrom()
        getPlaceTo()
    }

    private fun getPlaceFrom() {
        _placeFrom.value = localStorage.placeFrom
    }

    private fun getPlaceTo() {
        _placeTo.value = localStorage.placeTo
    }

    fun setPlaceFrom(place: String) {
        localStorage.placeFrom = place
    }

    fun setPlaceTo(place: String) {
        localStorage.placeTo = place
    }

//    private fun getMusicOffers() {
//        viewModelScope.launch(dispatcherWrapper.io) {
//            _isLoading.value = true
//            kotlin.runCatching {
//                getAirticketsUseCase.invoke()
//            }.fold(
//                onSuccess = {
//                    _data.value = it
//                },
//                onFailure = {
//                    Log.d("StateResult", "error = $it")
//                }
//            )
//            _isLoading.value = false
//        }
//    }
}