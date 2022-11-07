package com.example.ecommerce.data

import com.example.ecommerce.data.network.StoreService
import com.example.ecommerce.domain.StoreRepository
import com.example.ecommerce.domain.model.Store
import retrofit2.Response
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val storeService: StoreService
) : StoreRepository {
    override suspend fun getStore(): Response<Store> {
        return storeService.getStoreResponse()
    }
}