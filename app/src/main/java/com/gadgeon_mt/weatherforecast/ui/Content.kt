package com.gadgeon_mt.weatherforecast.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.gadgeon_mt.weatherforecast.base.BaseViewModel
import com.gadgeon_mt.weatherforecast.ui.commom.ErrorScreen
import com.gadgeon_mt.weatherforecast.ui.commom.ProgressScreen
import com.gadgeon_mt.weatherforecast.utils.ViewState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun <T> Content(
    viewModel: BaseViewModel<T>,
    SuccessScreen: @Composable() (t: T) -> Unit
) {
    when (val viewState = viewModel.stateFlow.collectAsState().value) {
        is ViewState.Loading -> ProgressScreen()
        is ViewState.Success -> {
            val isRefreshing by viewModel.isRefreshing.collectAsState()
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
                onRefresh = { viewModel.refresh() }
            ) {
                viewState.data?.let { SuccessScreen(t = it) }
            }
        }
        is ViewState.Error ->
            ErrorScreen(message = viewState.message, refresh = viewModel::refresh)
    }
}