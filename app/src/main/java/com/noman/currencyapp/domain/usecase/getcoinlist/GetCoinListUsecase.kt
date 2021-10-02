package com.noman.currencyapp.domain.usecase.getcoinlist

import com.noman.currencyapp.common.Resource
import com.noman.currencyapp.data.remote.datatransobject.CoinDto
import com.noman.currencyapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.util.zip.InflaterOutputStream
import javax.inject.Inject

class GetCoinListUsecase @Inject constructor(private val repository: CoinRepository) {

    fun invoke(): Flow<Resource<List<CoinDto>>> = flow {
        try {
            emit(Resource.Loading<List<CoinDto>>())
            val coinsList = repository.getCoinsList()
            emit(Resource.Success<List<CoinDto>>(coinsList))
        } catch (e: HttpException) {
            emit(Resource.Error<List<CoinDto>>(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach to server, Please check your internet."))
        }
    }


}