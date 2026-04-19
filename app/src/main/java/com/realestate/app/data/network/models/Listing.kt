package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class Listing(
    @SerializedName("id") var id: Long? = null,
    @SerializedName("offerType") var offerType: String? = null,
    @SerializedName("categories") var categories: ArrayList<String> = arrayListOf(),
    @SerializedName("prices") var prices: Prices? = Prices(),
    @SerializedName("address") var address: Address? = Address(),
    @SerializedName("characteristics") var characteristics: Characteristics? = Characteristics(),
    @SerializedName("localization") var localization: Localization? = Localization(),
    @SerializedName("lister") var lister: Lister? = Lister()
)
