package ru.kanogor.startscreenaviasales.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.kanogor.core.di.coreModule
import ru.kanogor.feature_airtickets.di.featureAirticketsModule
import ru.kanogor.feature_bell.di.featureBellModule
import ru.kanogor.feature_choose_country.di.featureChooseCountryModule
import ru.kanogor.feature_hotels.di.featureHotelsModule
import ru.kanogor.feature_profile.di.featureProfileModule
import ru.kanogor.feature_simply.di.featureSimplyModule
import ru.kanogor.feature_watch_all_tickets.di.featureWatchTicketsModule
import ru.kanogor.remote_api.di.apiModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(androidContext = this@App)
            androidLogger(level = Level.DEBUG)
            modules(
                featureAirticketsModule(),
                featureChooseCountryModule(),
                featureWatchTicketsModule(),
                featureHotelsModule(),
                featureBellModule(),
                featureProfileModule(),
                featureSimplyModule(),
                apiModule(),
                coreModule()
            )
        }
    }
}