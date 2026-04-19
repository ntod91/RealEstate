package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class Prices(
    @SerializedName("currency") var currency: String? = null,
    @SerializedName("buy") var buy: Buy? = Buy()
)
