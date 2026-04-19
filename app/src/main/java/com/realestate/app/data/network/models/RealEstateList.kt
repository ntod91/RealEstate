package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class RealEstateList(
    @SerializedName("from") var from: Long? = null,
    @SerializedName("size") var size: Long? = null,
    @SerializedName("total") var total: Long? = null,
    @SerializedName("results") var results: ArrayList<Results> = arrayListOf(),
    @SerializedName("maxFrom") var maxFrom: Long? = null
)
