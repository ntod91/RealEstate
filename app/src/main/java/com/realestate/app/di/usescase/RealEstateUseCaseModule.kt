package com.realestate.app.di.usescase

import com.realestate.app.data.repoisotory.RealEstateRepository
import com.realestate.app.domain.RealEstateUseCase
import com.realestate.app.domain.RealEstateUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RealEstateUseCaseModule {
    @Provides
    @Singleton
    fun provideRealEstateUseCase(realEstateRepository: RealEstateRepository): RealEstateUseCase =
        RealEstateUseCaseImpl(realEstateRepository)
}
