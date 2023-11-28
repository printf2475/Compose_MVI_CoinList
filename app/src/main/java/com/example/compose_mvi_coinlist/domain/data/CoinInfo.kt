package com.example.compose_mvi_coinlist.domain.data

data class CoinInfo(
    val symbol: String,
    val accTradeValue: String,
    val accTradeValue24H: String,
    val closingPrice: String,
    val fluctate24H: String,
    val fluctateRate24H: String,
    val maxPrice: String,
    val minPrice: String,
    val openingPrice: String,
    val prevClosingPrice: String,
    val unitsTraded: String,
    val unitsTraded24H: String
)


fun com.example.compose_mvi_coinlist.data.model.CoinInfo.toCoinInfo() = CoinInfo(
    symbol = symbol?:"",
    accTradeValue = accTradeValue?:"",
    accTradeValue24H = accTradeValue24H?:"",
    closingPrice = closingPrice?:"",
    fluctate24H = fluctate24H?:"",
    fluctateRate24H = fluctateRate24H?:"",
    maxPrice = maxPrice?:"",
    minPrice = minPrice?:"",
    openingPrice = openingPrice?:"",
    prevClosingPrice = prevClosingPrice?:"",
    unitsTraded = unitsTraded?:"",
    unitsTraded24H = unitsTraded24H?:""
)