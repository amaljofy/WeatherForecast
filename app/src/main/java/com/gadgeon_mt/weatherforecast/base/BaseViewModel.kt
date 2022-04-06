package com.gadgeon_mt.weatherforecast.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gadgeon_mt.weatherforecast.utils.ViewState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

open class BaseViewModel<T>(
    private val repository: BaseRepository<T>
) : ViewModel() {

    private val _stateFlow = MutableStateFlow<ViewState<T?>>(ViewState.Loading)
    val stateFlow: StateFlow<ViewState<T?>>
        get() = _stateFlow

    private val _isRefreshing = MutableStateFlow(false)
    val isRefreshing: StateFlow<Boolean>
        get() = _isRefreshing.asStateFlow()

    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            _isRefreshing.emit(true)
            repository.getResult().collect {
                _stateFlow.tryEmit(it)
            }
            _isRefreshing.emit(false)
        }
    }
}