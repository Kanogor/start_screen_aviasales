package ru.kanogor.core_ui.utils

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

const val DATE_PATTERN_DEFAULT = "yyyy-MM-dd"
const val DATE_PATTERN_DAY_MONTH = "dd LLL, E"
fun getYearFromString(dateTimeString: String): String {
    var dateFormat = SimpleDateFormat(DATE_PATTERN_DEFAULT, Locale.getDefault())
    val date = dateFormat.parse(dateTimeString)
    dateFormat = SimpleDateFormat(DATE_PATTERN_DAY_MONTH, Locale.getDefault())
    return dateFormat.format(date!!)
}

fun getCurrentDate(): String {
    val formatter = DateTimeFormatter.ofPattern(DATE_PATTERN_DAY_MONTH)
    return LocalDateTime.now().format(formatter)
}