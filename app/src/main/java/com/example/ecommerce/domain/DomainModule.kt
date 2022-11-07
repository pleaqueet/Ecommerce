package com.example.ecommerce.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Singleton
    @Provides
    fun provideGetStoreUseCase(storeRepository: StoreRepository): GetStoreUseCase {
        return GetStoreUseCase(repository = storeRepository)
    }
}