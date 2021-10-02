package com.noman.currencyapp.domain.usecase.getcoindetail

import com.noman.currencyapp.common.Resource
import com.noman.currencyapp.data.remote.datatransobject.coindetaildto.CoinDetailDto
import com.noman.currencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetialUsecase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetailDto>> = flow {
        try {
            emit(Resource.Loading<CoinDetailDto>())
            val coinDetail = repository.getCoinDetail(coinId)
            emit(Resource.Success<CoinDetailDto>(coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetailDto>(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach to server, Please check you internet."))
        }
    }
}