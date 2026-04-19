package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName


data class Localization(
    @SerializedName("primary") var primary: String? = null, @SerializedName("de") var de: De? = De()
)
