package com.tupleinfotech.officeproject.utils

import android.app.TimePickerDialog
import android.content.Context
import android.widget.TimePicker

class CustomTimePickerDialog(
    context: Context,
    private val onTimeSetListener: OnTimeSetListener?,
    hourOfDay: Int,
    minute: Int,
    is24HourView: Boolean
) : TimePickerDialog(context, onTimeSetListener, hourOfDay, minute, is24HourView) {

    private var minHour = -1
    private var minMinute = -1

    fun setMinTime(minHour: Int, minMinute: Int) {
        this.minHour = minHour
        this.minMinute = minMinute
    }

    override fun onTimeChanged(view: TimePicker?, hourOfDay: Int, minute: Int) {
        if (hourOfDay < minHour || (hourOfDay == minHour && minute < minMinute)) {
            // If the selected time is earlier than the minimum time, reset to the minimum time
            updateTime(minHour, minMinute)
        } else {
            super.onTimeChanged(view, hourOfDay, minute)
        }
    }
}
