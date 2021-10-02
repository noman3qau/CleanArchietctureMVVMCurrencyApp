package com.noman.currencyapp.presentation.coindetail

import com.noman.currencyapp.data.remote.datatransobject.CoinDto
import com.noman.currencyapp.data.remote.datatransobject.coindetaildto.CoinDetailDto

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinItem: CoinDetailDto? = null,
    val error: String = ""
)
