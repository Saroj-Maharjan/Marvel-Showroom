package com.sawrose.marvel_showroom.ui.main

import com.sawrose.marvel_showroom.core.mvi.AbstractViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor():
AbstractViewModel<MainContract.Event, MainContract.State, MainContract.Effect>(){
    override fun setInitialState(): MainContract.State {
        return MainContract.State(
            isLoading = true,
            isSuccess = false
        )
    }

    override fun handleEvent(event: MainContract.Event) {
        return setEvent(MainContract.Event.DirectToHome)
    }
}