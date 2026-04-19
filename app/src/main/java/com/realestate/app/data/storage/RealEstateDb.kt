package com.realestate.app.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.realestate.app.data.storage.dao.RealEstateDao
import com.realestate.app.data.storage.models.BookmarkedRealEstateEntity
import com.realestate.app.data.storage.models.RealEstateEntity


@Database(
    entities = [RealEstateEntity::class, BookmarkedRealEstateEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RealEstateDb : RoomDatabase() {
    abstract fun realEstateDao(): RealEstateDao
}
