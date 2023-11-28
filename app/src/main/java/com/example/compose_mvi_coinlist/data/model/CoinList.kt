package com.example.compose_mvi_coinlist.data.model

import com.google.gson.Gson
import org.json.JSONObject


data class CoinList(
    val `data`: HashMap<String, Any>,
    val status: String
)

fun CoinList.toCoinInfoList(): MutableList<CoinInfo> {
    val list = mutableListOf<CoinInfo>()
    data.forEach { (coinName, any) ->
        if (coinName != "date") {
            val coinInfoJson = JSONObject(Gson().toJson(any))
            val closingPrice = coinInfoJson.get("closing_price").toString()
            val unitsTraded = coinInfoJson.get("units_traded").toString()
            val accTradeValue = coinInfoJson.get("acc_trade_value").toString()
            val accTradeValue24H = coinInfoJson.get("acc_trade_value_24H").toString()
            val fluctate24H = coinInfoJson.get("fluctate_24H").toString()
            val fluctateRate24H = coinInfoJson.get("fluctate_rate_24H").toString()
            val maxPrice = coinInfoJson.get("max_price").toString()
            val minPrice = coinInfoJson.get("min_price").toString()
            val openingPrice = coinInfoJson.get("opening_price").toString()
            val prevClosingPrice = coinInfoJson.get("prev_closing_price").toString()
            val unitsTraded24H = coinInfoJson.get("units_traded_24H").toString()
            val coinInfo = CoinInfo(
                symbol = coinName,
                accTradeValue = accTradeValue,
                accTradeValue24H = accTradeValue24H,
                closingPrice = closingPrice,
                fluctate24H = fluctate24H,
                fluctateRate24H = fluctateRate24H,
                maxPrice = maxPrice,
                minPrice = minPrice,
                openingPrice = openingPrice,
                prevClosingPrice = prevClosingPrice,
                unitsTraded = unitsTraded,
                unitsTraded24H = unitsTraded24H,
            )
            list.add(coinInfo)
        }
    }
    return list

}
/*
{
  "status": "0000",
  "data": {
      `"GMT": {
          "opening_price": "1241",
          "closing_price": "1223",
          "min_price": "1214",
          "max_price": "1247",
          "units_traded": "134153.57375082",
          "acc_trade_value": "164964047.2977",
          "prev_closing_price": "1243",
          "units_traded_24H": "167388.74499314",
          "acc_trade_value_24H": "206294045.6053",
          "fluctate_24H": "-22",
          "fluctate_rate_24H": "-1.77"
        },

        "TAVA": {
          "opening_price": "1830",
          "closing_price": "1779",
          "min_price": "1753",
          "max_price": "1837",
          "units_traded": "435725.06653455",
          "acc_trade_value": "783324092.2456",
          "prev_closing_price": "1830",
          "units_traded_24H": "483421.721981",
          "acc_trade_value_24H": "870724421.3966",
          "fluctate_24H": "-56",
          "fluctate_rate_24H": "-3.05"
        },
        "date": "1659866049821"`
  }
}
* */
