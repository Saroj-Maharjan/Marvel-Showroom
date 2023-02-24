package com.sawrose.marvel_showroom.core.data.network.responses

/**
 * Character model for the response from the network.
 */
data class CharacterDTO(
    val id: Long,
    val name: String,
    val description: String,
    val thumbnail: ThumbnailDTO,
)
