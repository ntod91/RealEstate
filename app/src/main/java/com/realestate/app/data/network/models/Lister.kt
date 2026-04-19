package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class Lister(
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("logoUrl") var logoUrl: String? = null
)
