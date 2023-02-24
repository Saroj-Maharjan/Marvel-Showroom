package com.sawrose.marvel_showroom.features.home.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.sawrose.marvel_showroom.core.utils.SIDE_EFFECTS_KEY
import com.sawrose.marvel_showroom.features.home.HomeContract
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeScreen(
    state: HomeContract.State,
    effectFlow: Flow<HomeContract.Effect>?,
    onEventSent: (event: HomeContract.Event) -> Unit,
    onNavigationRequested: (HomeContract.Effect.Navigation) -> Unit,
) {
    LaunchedEffect(SIDE_EFFECTS_KEY) {
        effectFlow?.collect { effect ->
            when (effect) {
                is HomeContract.Effect.Navigation.Back ->
                    onNavigationRequested(HomeContract.Effect.Navigation.Back)
                is HomeContract.Effect.Navigation.ToDetail ->
                    onNavigationRequested(HomeContract.Effect.Navigation.ToDetail(effect.characterId))
                else -> {

                }
            }
        }
    }
}


