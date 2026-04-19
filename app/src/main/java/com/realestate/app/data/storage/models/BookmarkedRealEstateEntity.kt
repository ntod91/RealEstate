package com.realestate.app.data.storage.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = RealEstateEntity::class,
        parentColumns = ["id"],
        childColumns = ["realEstateId"],
        onDelete = ForeignKey.SET_DEFAULT
    )]
)
data class BookmarkedRealEstateEntity(
    @PrimaryKey val realEstateId: Long,
    val isBookmarked: Boolean,
)
