package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("id") var id: Long? = null,
    @SerializedName("remoteViewing") var remoteViewing: Boolean? = null,
    @SerializedName("listingType") var listingType: ListingType? = ListingType(),
    @SerializedName("listerBranding") var listerBranding: ListerBranding? = ListerBranding(),
    @SerializedName("listing") var listing: Listing? = Listing()
)
