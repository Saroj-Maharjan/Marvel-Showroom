package com.sawrose.marvel_showroom.core.data.network.responses

/**
 * Base response class for all the responses from the API
 */
data class BaseResponse<T>(
    val code: Any,
    val status: String,
    val message: String,
    val data: DataResponse<T>
)
