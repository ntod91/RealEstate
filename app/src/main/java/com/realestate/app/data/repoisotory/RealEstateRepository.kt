package com.realestate.app.data.repoisotory

import com.realestate.app.data.storage.models.RealEstateEntity
import com.realestate.app.domain.models.RealEstateDomain
import com.realestate.app.utils.Resource

interface RealEstateRepository {
    suspend fun fetchAllRealEstate(): Resource<List<RealEstateDomain>>
    suspend fun storeAllRealEstates(items: List<RealEstateEntity>)
    suspend fun updateBookmarkedRealEstate(id: Long, isBookmarked: Boolean): Resource<Unit>
}
