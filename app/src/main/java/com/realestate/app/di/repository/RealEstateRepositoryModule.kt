package com.realestate.app.di.repository

import com.realestate.app.data.network.RealEstateApi
import com.realestate.app.data.repoisotory.RealEstateRepository
import com.realestate.app.data.repoisotory.RealEstateRepositoryImpl
import com.realestate.app.data.storage.RealEstateDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RealEstateRepositoryModule {
    @Provides
    @Singleton
    fun provideRealEstateRepository(db: RealEstateDb, api: RealEstateApi): RealEstateRepository =
        RealEstateRepositoryImpl(db, api)
}
