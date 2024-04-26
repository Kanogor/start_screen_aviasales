package ru.kanogor.feature_airtickets.data

import android.content.SharedPreferences
import ru.kanogor.feature_airtickets.domain.model.LocalStorage

class PreferencesManager(private val sharedPreferences: SharedPreferences) : LocalStorage {
    override var placeFrom: String?
        get() = sharedPreferences.getString(TOKEN, DEFAULT_TOKEN)
        set(value) {
            sharedPreferences.edit()
                .putString(TOKEN, value)
                .apply()
        }

    companion object {
        private const val TOKEN = "token"
        private const val DEFAULT_TOKEN = "default_token"

    }
}