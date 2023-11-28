package com.example.compose_mvi_coinlist.data.model


data class CoinInfo(
    val symbol: String?,
    val accTradeValue: String?,
    val accTradeValue24H: String?,
    val closingPrice: String?,
    val fluctate24H: String?,
    val fluctateRate24H: String?,
    val maxPrice: String?,
    val minPrice: String?,
    val openingPrice: String?,
    val prevClosingPrice: String?,
    val unitsTraded: String?,
    val unitsTraded24H: String?
)