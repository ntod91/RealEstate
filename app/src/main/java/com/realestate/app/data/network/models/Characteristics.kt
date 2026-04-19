package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class Characteristics(
    @SerializedName("numberOfRooms") var numberOfRooms: Double? = null,
    @SerializedName("livingSpace") var livingSpace: Int? = null,
    @SerializedName("lotSize") var lotSize: Int? = null,
    @SerializedName("totalFloorSpace") var totalFloorSpace: Int? = null
)

