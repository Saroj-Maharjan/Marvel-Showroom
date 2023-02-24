package com.sawrose.marvel_showroom.core.data.network.services

import com.sawrose.marvel_showroom.core.data.network.responses.BaseResponse
import com.sawrose.marvel_showroom.core.data.network.responses.CharacterDTO
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Service to fetch the characters from the Marvel API
 */
interface MarvelService {

        /**
         * Fetches the characters from the Marvel API
         * @param apiKey The public key to access the Marvel API
         * @param hash The hash to access the Marvel API
         * @param ts The timestamp to access the Marvel API
         * @param offset The offset to fetch the characters from
         * @param limit The limit of characters to fetch
         * @return The response from the API
        */
        @GET("v1/public/characters")
        suspend fun getCharacters(
            @Query("apikey") apiKey: String,
            @Query("hash") hash: String,
            @Query("ts") timeStamp: String,
            @Query("offset") offset: Int,
            @Query("limit") limit: Int
        ): BaseResponse<CharacterDTO>
}