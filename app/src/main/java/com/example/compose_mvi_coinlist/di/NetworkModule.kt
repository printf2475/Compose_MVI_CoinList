package com.example.compose_mvi_coinlist.di

import com.example.compose_mvi_coinlist.data.api.CoinRestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideCoinBaseUrl(): String = com.example.compose_mvi_coinlist.BuildConfig.COIN_BASE_URL


    @Singleton
    @Provides
    fun provideOkHttpClient() = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()


    @Singleton
    @Provides
    fun provideCoinRetrofit(okHttpClient: OkHttpClient): CoinRestApi=
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(provideCoinBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinRestApi::class.java)



}