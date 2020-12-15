package com.zaki.mvvm_base.utils

import com.zaki.mvvm_base.utils.DateConstants.DAY_MILLIS
import com.zaki.mvvm_base.utils.DateConstants.HOUR_MILLIS
import com.zaki.mvvm_base.utils.DateConstants.MINUTE_MILLIS
import java.text.SimpleDateFormat
import java.util.*

fun getTimeAgo(inputDate: String): String {

    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH)
    val date: Date = inputFormat.parse(inputDate)!!
    var time = date.time
    if (time < 1000000000000L) { // if timestamp given in seconds, convert to millis
        time *= 1000
    }

    val now: Long = System.currentTimeMillis();
    if (time > now || time <= 0) {
        return "Just now"
    }

    val diff: Long = now - time
    return when {
        diff < MINUTE_MILLIS -> {
            "Just now"
        }
        diff < 2 * MINUTE_MILLIS -> {
            "A minute ago"
        }
        diff < 50 * MINUTE_MILLIS -> {
            "${diff / MINUTE_MILLIS} minutes ago"
        }
        diff < 90 * MINUTE_MILLIS -> {
            "An hour ago"
        }
        diff < 24 * HOUR_MILLIS -> {
            "${diff / HOUR_MILLIS} hours ago"
        }
        diff < 48 * HOUR_MILLIS -> {
            "Yesterday"
        }
        else -> {
            "${diff / DAY_MILLIS} days ago"
        }
    }
}