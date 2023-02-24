package com.sawrose.marvel_showroom.features.home

import androidx.lifecycle.viewModelScope
import com.sawrose.marvel_showroom.core.mvi.AbstractViewModel
import com.sawrose.marvel_showroom.domain.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
): AbstractViewModel<HomeContract.Event, HomeContract.State, HomeContract.Effect>() {

    init {
        loadCharacters()
    }

    override fun setInitialState(): HomeContract.State {
        return HomeContract.State(
            isLoading = true,
            charactersList = emptyList(),
            isError = false
        )
    }

    override fun handleEvent(event: HomeContract.Event) {
        return when(event) {
            is HomeContract.Event.CharacterSelection -> setEffect {
                HomeContract.Effect.Navigation.ToDetail(
                    "ID"
                )
            }
            is HomeContract.Event.Retry -> loadCharacters()
        }
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            setState { copy(isLoading = true, isError = false) }

            getCharactersUseCase.invoke(Unit)
        }
    }
}