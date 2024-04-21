package ru.kanogor.remote_api.di

import ru.kanogor.remote_api.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

const val BASE_URL = "https://drive.google.com/"

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
}