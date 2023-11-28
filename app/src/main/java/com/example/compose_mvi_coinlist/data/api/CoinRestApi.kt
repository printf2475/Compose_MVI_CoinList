package com.example.compose_mvi_coinlist.data.api

import com.example.compose_mvi_coinlist.data.model.CoinList
import retrofit2.http.*

interface CoinRestApi {
    @GET("ticker/ALL_KRW")
    suspend fun loadCoinList(): CoinList
}