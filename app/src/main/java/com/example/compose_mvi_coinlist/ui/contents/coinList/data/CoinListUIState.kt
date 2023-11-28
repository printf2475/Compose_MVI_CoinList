package com.example.compose_mvi_coinlist.ui.contents.coinList.data

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized
import com.example.compose_mvi_coinlist.domain.data.CoinInfo

data class CoinListUIState(
    val coinList: Async<List<CoinInfo>> = Uninitialized
): MavericksState
