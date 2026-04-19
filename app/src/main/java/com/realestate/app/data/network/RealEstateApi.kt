package com.realestate.app.data.network

import com.realestate.app.data.network.models.RealEstateList
import retrofit2.http.GET

interface RealEstateApi {
    @GET("properties")
    suspend fun getRealEstates(): RealEstateList
}
