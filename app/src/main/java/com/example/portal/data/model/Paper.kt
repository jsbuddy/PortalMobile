package com.example.portal.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.time.LocalDateTime

@Parcelize
data class Paper(
    val id: String,
    val code: String,
    val title: String,
    val session: String,
    val semester: Int,
    val date: LocalDateTime,
    val duration: Int,
    val active: Boolean
) : Parcelable