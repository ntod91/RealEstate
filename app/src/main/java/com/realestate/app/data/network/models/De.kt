package com.realestate.app.data.network.models

import com.google.gson.annotations.SerializedName

data class De(
    @SerializedName("attachments") var attachments: ArrayList<Attachments> = arrayListOf(),
    @SerializedName("text") var text: Text? = Text(),
    @SerializedName("urls") var urls: ArrayList<Urls> = arrayListOf()
)
