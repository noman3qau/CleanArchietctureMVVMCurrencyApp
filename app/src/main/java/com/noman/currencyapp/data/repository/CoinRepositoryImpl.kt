package com.noman.currencyapp.data.repository

import com.noman.currencyapp.data.remote.CoinPaprikaApi
import com.noman.currencyapp.data.remote.datatransobject.CoinDto
import com.noman.currencyapp.data.remote.datatransobject.coindetaildto.CoinDetailDto
import com.noman.currencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi) : CoinRepository {
    override suspend fun getCoinsList(): List<CoinDto> {
        return api.getCoinsList()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailDto {
        return api.getCoinDetailById(coinId)
    }

}