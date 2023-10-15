package com.example.avicultura_silsan.functions

import android.util.Log
import android.widget.Toast
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun String.toAmericanDateFormat(
    pattern: String = "yyyy-MM-dd"
): String {
    val date = Date(this)
    val formatter = SimpleDateFormat(
        pattern, Locale("pt-br")
    ).apply {
        timeZone = TimeZone.getTimeZone("GMT")
    }
    return formatter.format(date)
}

fun isOver18Years(dateString: String): Boolean {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    try {
        val date = dateFormat.parse(dateString)
        if (date != null) {
            val calendar = Calendar.getInstance()
            calendar.time = date
            val currentDate = Calendar.getInstance()
            currentDate.add(Calendar.YEAR, -18)
            return calendar.before(currentDate)
        }
    } catch (e: ParseException) {
        Log.e("Morreu", "isOver18Years: $e", )
    }
    return false
}

