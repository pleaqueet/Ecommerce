package com.example.ecommerce.domain.model


import com.example.ecommerce.domain.model.BestSeller
import com.example.ecommerce.domain.model.HomeStore
import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("best_seller")
    val bestSeller: List<BestSeller>,
    @SerializedName("home_store")
    val homeStore: List<HomeStore>
)