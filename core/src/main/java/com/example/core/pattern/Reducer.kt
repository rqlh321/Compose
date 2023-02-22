package com.example.core.pattern

abstract class Reducer<T : ScreenState> {

    abstract fun reduce(sideEffect: SideEffect<T>)

}