package com.example.compose_mvi_coinlist.ui.contents.coinList

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.example.compose_mvi_coinlist.di.hilt.AssistedViewModelFactory
import com.example.compose_mvi_coinlist.di.hilt.hiltMavericksViewModelFactory
import com.example.compose_mvi_coinlist.domain.usecase.GetCoinListUseCase
import com.example.compose_mvi_coinlist.ui.contents.coinList.data.CoinListUIState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class CoinListViewModel @AssistedInject constructor(
    @Assisted initialState: CoinListUIState,
    private val getCoinListUseCase: GetCoinListUseCase,
): MavericksViewModel<CoinListUIState>(initialState) {

    init {
        suspend{ getCoinListUseCase() }.execute {
            copy(coinList = it)
        }
    }


    @AssistedFactory
    interface Factory : AssistedViewModelFactory<CoinListViewModel, CoinListUIState> {
        override fun create(state: CoinListUIState): CoinListViewModel
    }

    companion object : MavericksViewModelFactory<CoinListViewModel, CoinListUIState> by hiltMavericksViewModelFactory()

}