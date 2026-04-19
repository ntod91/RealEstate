package com.realestate.app.data.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RealEstateEntity(
    @PrimaryKey val id: Long,
    val price: String,
    val imageUrl: String,
    val title: String,
    val address: String
)
