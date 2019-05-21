package com.example.functionadvanced

import java.text.SimpleDateFormat
import java.util.*

//Top level function
fun getCurrentDate(): String {
    val date = Date()
    val dateFormat = "dd/MM/yyyy"
    val sdf = SimpleDateFormat(dateFormat)

    return sdf.format(date)
}