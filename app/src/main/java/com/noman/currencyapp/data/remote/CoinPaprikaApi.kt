package com.noman.currencyapp.data.remote

import com.noman.currencyapp.data.remote.datatransobject.CoinDto
import com.noman.currencyapp.data.remote.datatransobject.coindetaildto.CoinDetailDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoinsList(): List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinDetailById(@Path("coinId") coinId: String): CoinDetailDto

}