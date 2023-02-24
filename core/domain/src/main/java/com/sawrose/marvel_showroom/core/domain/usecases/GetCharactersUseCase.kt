package com.sawrose.marvel_showroom.core.domain.usecases

import com.sawrose.marvel_showroom.core.data.network.responses.BaseResponse
import com.sawrose.marvel_showroom.core.data.network.responses.CharacterDTO
import com.sawrose.marvel_showroom.core.data.repository.MarvelRemoteRepository
import com.sawrose.marvel_showroom.core.domain.SuspendUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: MarvelRemoteRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
): SuspendUseCase<Unit, BaseResponse<CharacterDTO>>(dispatcher) {
    override suspend fun execute(parameters: Unit): BaseResponse<CharacterDTO> {
        return repository.getCharacters(0, 20)
    }

}