package com.example.core.pattern

import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class ReducerImpl<T : ScreenState> @Inject constructor(
    private val state: MutableStateFlow<T>
) : Reducer<T>() {

    override fun reduce(sideEffect: SideEffect<T>) {
        state.value = sideEffect.reduce(state.value)
    }

}