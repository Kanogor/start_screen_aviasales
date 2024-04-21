package ru.kanogor.core.wrapper

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherWrapper {

    val io: CoroutineDispatcher
}