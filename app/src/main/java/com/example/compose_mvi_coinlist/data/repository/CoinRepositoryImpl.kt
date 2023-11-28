package com.example.compose_mvi_coinlist.data.repository

import com.example.compose_mvi_coinlist.data.api.CoinRestApi
import com.example.compose_mvi_coinlist.data.model.CoinList
import com.example.compose_mvi_coinlist.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val coinRestApi: CoinRestApi): CoinRepository {

    override suspend fun loadCoinList(): CoinList =coinRestApi.loadCoinList()
}