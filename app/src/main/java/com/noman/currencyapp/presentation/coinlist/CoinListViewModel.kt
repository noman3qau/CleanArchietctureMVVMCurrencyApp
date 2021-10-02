package com.noman.currencyapp.presentation.coinlist.components


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noman.currencyapp.common.Resource
import com.noman.currencyapp.domain.usecase.getcoinlist.GetCoinListUsecase
import com.noman.currencyapp.presentation.coinlist.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val coinListUsecase: GetCoinListUsecase) :
    ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoinList()
    }

    /**
     * This function get the Coins List from Repository via CoinListUsecase
     */
    private fun getCoinList() {
        coinListUsecase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coinList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        CoinListState(error = result.message ?: "Unexpected error occurred!")
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope) // This is to launch in ViewModel Scope/**/
    }

}