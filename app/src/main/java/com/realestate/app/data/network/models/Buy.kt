package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class Buy(
    @SerializedName("area") var area: String? = null,
    @SerializedName("price") var price: Long? = null,
    @SerializedName("interval") var interval: String? = null
)
