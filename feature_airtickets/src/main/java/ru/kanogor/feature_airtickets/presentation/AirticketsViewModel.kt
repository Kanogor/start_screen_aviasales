package ru.kanogor.feature_airtickets.presentation

import android.util.Log
import ru.kanogor.core.base.BaseViewModel
import ru.kanogor.core.wrapper.DispatcherWrapper
import ru.kanogor.feature_airtickets.domain.use_case.GetAirticketsUseCase
import ru.kanogor.feature_airtickets.presentation.state.MusicOffersState

class AirticketsViewModel(
    private val getAirticketsUseCase: GetAirticketsUseCase,
    private val dispatcherWrapper: DispatcherWrapper,
) : BaseViewModel<MusicOffersState>(MusicOffersState()) {

    init {
        getMusicOffers()
    }

    private fun getMusicOffers() {
        scopeLaunch(context = dispatcherWrapper.io, onError = ::onError) {
            viewState = viewState.copy(isLoading = true, isError = false)
            viewState = viewState.copy(isLoading = false, musicOffers = getAirticketsUseCase())
        }
    }


    private fun onError(e: Exception) {
        Log.d("StateResult", "error = ${e}")
        viewState = viewState.copy(isLoading = false, isError = true)
    }
}