package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("country") var country: String? = null,
    @SerializedName("locality") var locality: String? = null,
    @SerializedName("postalCode") var postalCode: String? = null,
    @SerializedName("region") var region: String? = null,
    @SerializedName("street") var street: String? = null,
    @SerializedName("geoCoordinates") var geoCoordinates: GeoCoordinates? = GeoCoordinates()
)
