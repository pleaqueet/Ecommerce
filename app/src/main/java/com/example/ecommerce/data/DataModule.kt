package com.example.ecommerce.data

import com.example.ecommerce.data.network.StoreService
import com.example.ecommerce.domain.StoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideStoreRepository(storeService: StoreService): StoreRepository {
        return StoreRepositoryImpl(storeService)
    }

    @Singleton
    @Provides
    fun provideStoreService(retrofit: Retrofit): StoreService {
        return retrofit.create(StoreService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(StoreService.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}