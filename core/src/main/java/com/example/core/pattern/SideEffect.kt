package com.example.core.pattern

abstract class SideEffect<T : ScreenState> {
    abstract fun reduce(state: T): T
}