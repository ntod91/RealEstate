package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class Text(
    @SerializedName("title") var title: String? = null
)
