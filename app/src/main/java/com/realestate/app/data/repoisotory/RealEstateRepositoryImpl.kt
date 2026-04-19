package com.realestate.app.data.repoisotory

import com.realestate.app.data.mappers.RealEstateMapper.toDb
import com.realestate.app.data.network.RealEstateApi
import com.realestate.app.data.storage.RealEstateDb
import com.realestate.app.data.storage.models.BookmarkedRealEstateEntity
import com.realestate.app.data.storage.models.RealEstateEntity
import com.realestate.app.domain.mappers.RealEstateDomainMapper.toDomain
import com.realestate.app.domain.models.RealEstateDomain
import com.realestate.app.utils.Defaults
import com.realestate.app.utils.Resource
import javax.inject.Inject

class RealEstateRepositoryImpl @Inject constructor(
    private val db: RealEstateDb, private val api: RealEstateApi
) : RealEstateRepository {

    override suspend fun fetchAllRealEstate(): Resource<List<RealEstateDomain>> = try {
        storeAllRealEstates(api.getRealEstates().toDb())
        Resource.Success(db.realEstateDao().getAll().toDomain())
    } catch (e: Exception) {
        if (db.realEstateDao().getNumberOfEntries() > Defaults.DEFAULT_INT) {
            Resource.Success(db.realEstateDao().getAll().toDomain())
        } else {
            Resource.Error(message = e.message ?: Defaults.DEFAULT_STRING)
        }
    }

    override suspend fun storeAllRealEstates(items: List<RealEstateEntity>) = try {
        db.realEstateDao().saveAll(items)
    } catch (e: Exception) {
        e.printStackTrace()
    }


    override suspend fun updateBookmarkedRealEstate(
        id: Long, isBookmarked: Boolean
    ): Resource<Unit> = try {
        db.realEstateDao().updateBookmark(BookmarkedRealEstateEntity(id, isBookmarked))
        Resource.Success(Unit)
    } catch (e: Exception) {
        Resource.Error(message = e.message ?: Defaults.DEFAULT_STRING)
    }
}
