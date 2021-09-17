package com.example.learning.tab2

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class AnimeResults (
    @SerializedName("results")
    val results: List<Anime>

    ) : Parcelable {
    constructor() : this(mutableListOf())
}
