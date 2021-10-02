package com.noman.currencyapp.presentation.coinlist

import com.noman.currencyapp.data.remote.datatransobject.CoinDto

data class CoinListState(
    val isLoading: Boolean = false,
    val coinList: List<CoinDto> = emptyList(),
    val error: String = ""
)
