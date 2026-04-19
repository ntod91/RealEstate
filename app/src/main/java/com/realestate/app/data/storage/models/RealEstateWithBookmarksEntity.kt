package com.realestate.app.data.storage.models

import androidx.room.Embedded
import androidx.room.Relation

data class RealEstateWithBookmark(
    @Embedded val realEstate: RealEstateEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "realEstateId"
    ) val bookmarkedRealEstateEntity: BookmarkedRealEstateEntity?
)
