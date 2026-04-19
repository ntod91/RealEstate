package com.realestate.app.domain

import com.realestate.app.data.repoisotory.RealEstateRepository
import com.realestate.app.domain.models.RealEstateDomain
import com.realestate.app.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RealEstateUseCaseImpl @Inject constructor(private val realEstateRepository: RealEstateRepository) :
    RealEstateUseCase {
    override suspend fun fetchRealEstate(): Flow<Resource<List<RealEstateDomain>>> = flow {
        emit(realEstateRepository.fetchAllRealEstate())
    }.flowOn(Dispatchers.IO)

    override suspend fun bookmarkRealEstate(
        id: Long, isBookmarked: Boolean
    ): Flow<Resource<Unit>> = flow {
        emit(realEstateRepository.updateBookmarkedRealEstate(id = id, isBookmarked = isBookmarked))
    }.flowOn(Dispatchers.IO)
}
