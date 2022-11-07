package com.example.ecommerce.domain

import com.example.ecommerce.domain.model.Store
import retrofit2.Response

interface StoreRepository {
    suspend fun getStore() : Response<Store>
}