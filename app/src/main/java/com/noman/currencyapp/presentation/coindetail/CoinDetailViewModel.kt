package com.noman.currencyapp.presentation.coindetail


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noman.currencyapp.common.Constants
import com.noman.currencyapp.common.Resource
import com.noman.currencyapp.domain.usecase.getcoindetail.GetCoinDetialUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinDetailUsecase: GetCoinDetialUsecase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoinDetailt(coinId)
        }
    }

    /**
     * This function get the Coins Detail from Repository via GetCoinDetailUsecase
     */
    private fun getCoinDetailt(coinId: String) {
        coinDetailUsecase.invoke(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coinItem = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        CoinDetailState(error = result.message ?: "Unexpected error occurred!")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope) // This is to launch in ViewModel Scope/**/
    }

}