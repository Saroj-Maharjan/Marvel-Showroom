package com.sawrose.marvel_showroom.core.network

import javax.inject.Qualifier

enum class MarvelDispatcher  {
    IO
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: MarvelDispatcher)