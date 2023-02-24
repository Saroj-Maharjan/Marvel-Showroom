package com.sawrose.marvel_showroom.features.home

import com.sawrose.marvel_showroom.core.mvi.MVIEvent
import com.sawrose.marvel_showroom.core.mvi.MVISideEffect
import com.sawrose.marvel_showroom.core.mvi.MVIViewState
import com.sawrose.marvel_showroom.data.network.responses.CharacterDTO

class HomeContract {

    sealed class Event: MVIEvent {
        object CharacterSelection : Event()
        object Retry : Event()
    }

    data class State(
        val isLoading: Boolean,
        val charactersList: List<CharacterDTO>,
        val isError: Boolean
    ): MVIViewState

    sealed class Effect: MVISideEffect {
        object DataWasLoaded: Effect()

        sealed class Navigation : Effect() {
            data class ToDetail(val characterId: String): Navigation()
            object Back: Navigation()
        }
    }
}