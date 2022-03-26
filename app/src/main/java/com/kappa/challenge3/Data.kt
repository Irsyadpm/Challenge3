package com.kappa.challenge3

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Data(
    val name: String,
    val age: String,
    val address: String,
    val job: String
) : Parcelable