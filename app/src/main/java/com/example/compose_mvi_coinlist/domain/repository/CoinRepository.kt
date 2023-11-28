package com.example.compose_mvi_coinlist.domain.repository

import com.example.compose_mvi_coinlist.data.model.CoinList


interface CoinRepository {
    suspend fun loadCoinList(): CoinList
}