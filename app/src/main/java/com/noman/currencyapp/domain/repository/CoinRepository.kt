package com.noman.currencyapp.domain.repository

import com.noman.currencyapp.data.remote.datatransobject.CoinDto
import com.noman.currencyapp.data.remote.datatransobject.coindetaildto.CoinDetailDto

interface CoinRepository {
    suspend fun getCoinsList(): List<CoinDto>
    suspend fun getCoinDetail(coinId: String): CoinDetailDto
}