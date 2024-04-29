package com.example.standard_assignment_4.data

import android.os.Parcelable
import com.example.standard_assignment_4.presentation.MultiViewEnum
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Card(
    val userName: String,
    val cardNumber: String,
    val cardType: String,
    val period: String,
    val balance: Double,
    val cardManager: String,
    val cardViewType: MultiViewEnum
):Parcelable
