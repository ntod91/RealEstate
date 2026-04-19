package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class GeoCoordinates(
    @SerializedName("latitude") var latitude: Double? = null,
    @SerializedName("longitude") var longitude: Double? = null

)
