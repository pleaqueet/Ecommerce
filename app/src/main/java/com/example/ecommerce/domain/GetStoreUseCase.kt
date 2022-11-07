package com.example.ecommerce.domain

class GetStoreUseCase(private val repository: StoreRepository) {
    suspend fun getStore() = repository.getStore()
}