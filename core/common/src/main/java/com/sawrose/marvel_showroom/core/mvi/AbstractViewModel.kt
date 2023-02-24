package com.sawrose.marvel_showroom.core.mvi

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class AbstractViewModel<
    Event: MVIEvent,
    UIState: MVIViewState,
    Effect: MVISideEffect
>(): ViewModel(){

    abstract fun setInitialState(): UIState
    abstract fun handleEvent(event: Event)

    private val initialState: UIState by lazy { setInitialState() }
    private val _states: MutableState<UIState> = mutableStateOf(initialState)
    val states: State<UIState> = _states

    private val _events = MutableSharedFlow<Event>()

    private val _effects: Channel<Effect> = Channel()
    val effects = _effects.receiveAsFlow()



    init {
        subscribeToEvents()
    }

    private fun subscribeToEvents(){
        viewModelScope.launch {
            _events.collect { event ->
                handleEvent(event)
            }
        }
    }

    fun setEvent(event: Event){
        viewModelScope.launch {
            _events.emit(event)
        }
    }

    protected fun setState(reducer: UIState.() -> UIState){
        val newState = _states.value.reducer()
        _states.value = newState
    }

    protected fun setEffect(builder: () -> Effect){
        val effectiveValue = builder()
        viewModelScope.launch {
            _effects.send(effectiveValue)
        }
    }
}