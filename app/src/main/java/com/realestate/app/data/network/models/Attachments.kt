package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class Attachments(
    @SerializedName("type") var type: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("file") var file: String? = null
)
