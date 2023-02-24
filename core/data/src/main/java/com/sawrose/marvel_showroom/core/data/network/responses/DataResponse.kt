package com.sawrose.marvel_showroom.core.data.network.responses

/**
 * Base response class for all the responses from the API
 */
data class DataResponse<T>(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<T>
)
