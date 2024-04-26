package ru.kanogor.remote_api.sharedpref

import android.content.SharedPreferences

class PreferencesManager(private val sharedPreferences: SharedPreferences) : LocalStorage {
    override var placeFrom: String?
        get() = sharedPreferences.getString(KEY_FROM, DEFAULT_FROM)
        set(value) {
            sharedPreferences.edit()
                .putString(KEY_FROM, value)
                .apply()
        }
    override var placeTo: String?
        get() = sharedPreferences.getString(KEY_TO, DEFAULT_TO)
        set(value) {
            sharedPreferences.edit()
                .putString(KEY_TO, value)
                .apply()
        }

    companion object {
        private const val KEY_FROM = "key_from"
        private const val KEY_TO = "key_to"
        private const val DEFAULT_FROM = "Откуда-Москва"
        private const val DEFAULT_TO = "Куда-Турция"

    }
}