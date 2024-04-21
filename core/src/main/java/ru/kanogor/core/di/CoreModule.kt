package ru.kanogor.core.di

import ru.kanogor.core.wrapper.DispatcherWrapper
import ru.kanogor.core.wrapper.DispatcherWrapperImpl
import org.koin.dsl.module

fun coreModule() = module {

    single<DispatcherWrapper> { DispatcherWrapperImpl() }
}