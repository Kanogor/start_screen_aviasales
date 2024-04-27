package ru.kanogor.remote_api.di

import android.app.Application
import android.content.Context
import ru.kanogor.remote_api.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import ru.kanogor.remote_api.sharedpref.LocalStorage
import ru.kanogor.remote_api.sharedpref.PreferencesManager

const val BASE_URL = "https://drive.google.com/"
const val SHARED_PREF = "SharedPref_base"

fun apiModule() = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    single {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single<Api> { get<Retrofit>().create() }

    single { provideAppPreference(androidApplication()) }
}

private fun provideAppPreference(application: Application): LocalStorage {
    val myPref = application.applicationContext.getSharedPreferences(
        SHARED_PREF,
        Context.MODE_PRIVATE
    )
    return PreferencesManager(myPref)
}