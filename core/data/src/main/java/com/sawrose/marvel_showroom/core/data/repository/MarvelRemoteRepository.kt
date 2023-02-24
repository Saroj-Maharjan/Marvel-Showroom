package com.sawrose.marvel_showroom.core.data.repository

import com.sawrose.marvel_showroom.core.extension.toMD5
import com.sawrose.marvel_showroom.data.BuildConfig
import com.sawrose.marvel_showroom.data.network.responses.BaseResponse
import com.sawrose.marvel_showroom.data.network.responses.CharacterDTO
import com.sawrose.marvel_showroom.data.network.services.MarvelService


private const val API_PUBLIC_KEY = BuildConfig.MARVEL_API_KEY_PUBLIC
private const val API_PRIVATE_KEY = BuildConfig.MARVEL_API_KEY_PRIVATE
private const val HASH_FORMAT = "%s%s%s"
/**
 * Remote repository for the Marvel API.
 */
class MarvelRemoteRepository(
    internal val service: MarvelService
) {
    /**
     * Get the list of characters from the Marvel API.
     * @param offset Skip the specified number of resources in the result set.
     * @param limit Limit the result set to the specified number of resources.
     * @return Response for comic characters resource.
     */
    suspend fun getCharacters(offset: Int, limit: Int): BaseResponse<CharacterDTO> {
        val timeStamp = System.currentTimeMillis().toString()
        return service.getCharacters(
            apiKey = API_PUBLIC_KEY,
            hash = generateApiHash(timeStamp),
            timeStamp = timeStamp,
            offset = offset,
            limit = limit
        )
    }
}

// ============================================================================================
//  Private generators methods
// ============================================================================================

/**
 * Generate a md5 digest of the timestamp parameter, private API key and public.
 *
 * @param timestamp A digital current record of the time.
 * @return The MD5 Hash
 */
private fun generateApiHash(timestamp: String) =
    HASH_FORMAT.format(timestamp, API_PRIVATE_KEY, API_PUBLIC_KEY).toMD5()