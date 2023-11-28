package com.example.compose_mvi_coinlist.di

import com.example.compose_mvi_coinlist.di.hilt.AssistedViewModelFactory
import com.example.compose_mvi_coinlist.di.hilt.MavericksViewModelComponent
import com.example.compose_mvi_coinlist.di.hilt.ViewModelKey
import com.example.compose_mvi_coinlist.ui.contents.coinList.CoinListViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap

@Module
@InstallIn(MavericksViewModelComponent::class)
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinListViewModel::class)
    fun exampleViewModelFactory(factory: CoinListViewModel.Factory): AssistedViewModelFactory<*, *>

}