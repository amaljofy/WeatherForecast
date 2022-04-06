package com.gadgeon_mt.weatherforecast.base

import android.content.Context
import com.gadgeon_mt.weatherforecast.R
import com.gadgeon_mt.weatherforecast.utils.ViewState
import com.gadgeon_mt.weatherforecast.utils.isNetworkAvailable
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

abstract class BaseRepository<T>(
    private val context: Context,
    private val ioDispatcher: CoroutineDispatcher
) {
    protected abstract suspend fun query(): T?

    protected abstract suspend fun fetch(): T

    protected abstract suspend fun saveFetchResult(t: T)

    fun getResult(): Flow<ViewState<T?>> = flow {
        emit(ViewState.Loading)
        if (context.isNetworkAvailable()) {
            try {
                emit(ViewState.Success(fetch()))
                saveFetchResult(fetch())
            } catch (t: Throwable) {
                emit(ViewState.Error(context.getString(R.string.failed_loading_msg)))
            }
        } else {
            emit(ViewState.Success(query()))
        }
    }.flowOn(ioDispatcher)
        .catch { Timber.e(it) }
}