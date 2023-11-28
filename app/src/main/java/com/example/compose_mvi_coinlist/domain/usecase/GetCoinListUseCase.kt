package com.example.compose_mvi_coinlist.domain.usecase

import com.example.compose_mvi_coinlist.data.model.toCoinInfoList
import com.example.compose_mvi_coinlist.domain.data.toCoinInfo
import com.example.compose_mvi_coinlist.domain.repository.CoinRepository
import javax.inject.Inject

class GetCoinListUseCase @Inject constructor(private val coinRepository: CoinRepository) {
    suspend operator fun invoke() = coinRepository.loadCoinList().toCoinInfoList().map { it.toCoinInfo() }
}