package com.realestate.app.domain

import com.realestate.app.domain.models.RealEstateDomain
import com.realestate.app.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RealEstateUseCase {
    suspend fun fetchRealEstate(): Flow<Resource<List<RealEstateDomain>>>
    suspend fun bookmarkRealEstate(id: Long, isBookmarked: Boolean): Flow<Resource<Unit>>
}
