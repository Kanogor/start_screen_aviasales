package ru.kanogor.core_ui.utils

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

const val DATE_PATTERN_DEFAULT = "yyyy-MM-dd"
const val DATE_PATTERN_DAY_MONTH = "dd LLL, E"
const val DATE_PATTERN_DAY_MONTH_FULL = "dd MMMM"
const val DATE_PATTERN_DAY_LONG_DATE = "yyyy-MM-dd'T'HH:mm:ss"
const val DATE_PATTERN_HOUR_MIN = "HH:mm"
const val DATE_PATTERN_HOUR = "HH"

fun getDayMonthFromString(dateTimeString: String): String {
    var dateFormat = SimpleDateFormat(DATE_PATTERN_DEFAULT, Locale.getDefault())
    val date = dateFormat.parse(dateTimeString)
    dateFormat = SimpleDateFormat(DATE_PATTERN_DAY_MONTH, Locale.getDefault())
    return dateFormat.format(date!!)
}

fun getHourFromLongDate(dateTimeString: String): String {
    var dateFormat = SimpleDateFormat(DATE_PATTERN_DAY_LONG_DATE, Locale.getDefault())
    val date = dateFormat.parse(dateTimeString)
    dateFormat = SimpleDateFormat(DATE_PATTERN_HOUR_MIN, Locale.getDefault())
    return dateFormat.format(date!!)
}

fun getFullDayMonthFromString(dateTimeString: String): String {
    var dateFormat = SimpleDateFormat(DATE_PATTERN_DEFAULT, Locale.getDefault())
    val date = dateFormat.parse(dateTimeString)
    dateFormat = SimpleDateFormat(DATE_PATTERN_DAY_MONTH_FULL, Locale.getDefault())
    return dateFormat.format(date!!)
}

fun getCurrentDate(): String {
    val formatter = DateTimeFormatter.ofPattern(DATE_PATTERN_DAY_MONTH)
    return LocalDateTime.now().format(formatter)
}

fun getCurrentDateFull(): String {
    val formatter = DateTimeFormatter.ofPattern(DATE_PATTERN_DAY_MONTH_FULL)
    return LocalDateTime.now().format(formatter)
}

fun convertDateToLong(date: String): Long {
    val dateFormat = SimpleDateFormat(DATE_PATTERN_DAY_LONG_DATE, Locale.getDefault())
    return dateFormat.parse(date)?.time ?: 0
}

fun convertLongToTime(time: Long): String {
    val date = Date(time)
    val format = SimpleDateFormat(DATE_PATTERN_HOUR, Locale.getDefault())
    return format.format(date)
}