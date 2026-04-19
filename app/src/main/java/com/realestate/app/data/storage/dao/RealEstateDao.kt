package com.realestate.app.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.realestate.app.data.storage.models.BookmarkedRealEstateEntity
import com.realestate.app.data.storage.models.RealEstateEntity
import com.realestate.app.data.storage.models.RealEstateWithBookmark

@Dao
interface RealEstateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(items: List<RealEstateEntity>)

    @Transaction
    @Query("SELECT * FROM RealEstateEntity")
    fun getAll(): List<RealEstateWithBookmark>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateBookmark(bookmarkedRealEstateEntity: BookmarkedRealEstateEntity)

    @Query("SELECT COUNT(*) FROM RealEstateEntity")
    fun getNumberOfEntries(): Int
}
