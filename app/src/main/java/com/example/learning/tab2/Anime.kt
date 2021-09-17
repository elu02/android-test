package com.example.learning.tab2

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Anime (
    @SerializedName("mal_id")
    val mal_id : String?,

    @SerializedName("title")
    val title : String?,

    @SerializedName("score")
    val score : String?,

    @SerializedName("image_url")
    val image_url : String?
    ) : Parcelable 