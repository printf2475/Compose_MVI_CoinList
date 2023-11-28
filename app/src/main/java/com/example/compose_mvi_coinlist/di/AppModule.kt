package com.example.compose_mvi_coinlist.di

import com.example.compose_mvi_coinlist.data.api.CoinRestApi
import com.example.compose_mvi_coinlist.data.repository.CoinRepositoryImpl
import com.example.compose_mvi_coinlist.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinRepository(coinRestApi: CoinRestApi) : CoinRepository {
        return CoinRepositoryImpl(coinRestApi)
    }

}