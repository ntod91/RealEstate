package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class ListingType(
    @SerializedName("type") var type: String? = null
)
