package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class ListerBranding(
    @SerializedName("logoUrl") var logoUrl: String? = null,
    @SerializedName("legalName") var legalName: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("address") var address: Address? = Address(),
    @SerializedName("adActive") var adActive: Boolean? = null,
    @SerializedName("isQualityPartner") var isQualityPartner: Boolean? = null,
    @SerializedName("isPremiumBranding") var isPremiumBranding: Boolean? = null,
    @SerializedName("profilePageUrlKeyword") var profilePageUrlKeyword: String? = null
)
