package com.realestate.app.domain.mappers

import com.realestate.app.data.storage.models.RealEstateWithBookmark
import com.realestate.app.domain.models.RealEstateDomain

object RealEstateDomainMapper {
    fun List<RealEstateWithBookmark>.toDomain(): List<RealEstateDomain> = this.map {
        RealEstateDomain(
            id = it.realEstate.id,
            price = it.realEstate.price,
            imageUrl = it.realEstate.imageUrl,
            title = it.realEstate.title,
            address = it.realEstate.address,
            isBookmarked = it.bookmarkedRealEstateEntity?.isBookmarked ?: false
        )
    }
}
