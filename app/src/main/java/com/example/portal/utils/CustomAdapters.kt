package com.example.portal.utils

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.portal.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@BindingAdapter("visibleIf")
fun setVisibleIf(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("formatDate")
fun formatDate(view: TextView, date: LocalDateTime) {
    view.text = date.format(DateTimeFormatter.ofPattern("d, MMM y"))
}

@BindingAdapter("formatTime")
fun formatTime(view: TextView, date: LocalDateTime) {
    view.text = date.format(DateTimeFormatter.ofPattern("HH:mma"))
}