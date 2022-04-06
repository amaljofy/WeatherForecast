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
        query()?.let {
            // ****** STEP 1: VIEW CACHE ******
            emit(ViewState.Success(it))
            // ****** STEP 2: MAKE NETWORK CALL, SAVE RESULT TO CACHE ******
            refresh()
            // ****** STEP 3: VIEW CACHE ******
            emit(ViewState.Success(query()))
        } ?: run {
            if (context.isNetworkAvailable()) {
                try {
                    // ****** STEP 1: MAKE NETWORK CALL, SAVE RESULT TO CACHE ******
                    refresh()
                    // ****** STEP 2: VIEW CACHE ******
                    emit(ViewState.Success(query()))
                } catch (t: Throwable) {
                    emit(ViewState.Error(context.getString(R.string.failed_loading_msg)))
                }
            } else {
                emit(ViewState.Error(context.getString(R.string.failed_network_msg)))
            }
        }
    }.flowOn(ioDispatcher)
        .catch { Timber.e(it) }

    private suspend fun refresh() {
        saveFetchResult(fetch())
    }
}