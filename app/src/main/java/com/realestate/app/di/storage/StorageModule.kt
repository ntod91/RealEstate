package com.realestate.app.di.storage

import android.content.Context
import androidx.room.Room
import com.realestate.app.data.storage.RealEstateDb
import com.realestate.app.data.storage.dao.RealEstateDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): RealEstateDb =
        Room.databaseBuilder(context, RealEstateDb::class.java, "smg_db").build()

    @Provides
    fun provideRealEstateDao(db: RealEstateDb): RealEstateDao = db.realEstateDao()

}
