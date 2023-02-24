package com.sawrose.marvel_showroom.ui.main

import com.sawrose.marvel_showroom.core.mvi.MVIEvent
import com.sawrose.marvel_showroom.core.mvi.MVISideEffect
import com.sawrose.marvel_showroom.core.mvi.MVIViewState

class MainContract {
    sealed class Event: MVIEvent {
        object DirectToHome: Event()
    }

    data class State(
        val isLoading: Boolean,
        val isSuccess: Boolean
    ): MVIViewState

    sealed class Effect: MVISideEffect {
    }
}