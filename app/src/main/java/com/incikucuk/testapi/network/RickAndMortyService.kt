package com.incikucuk.testapi.network

import com.incikucuk.testapi.network.response.GetCharacterByIdResponse
import com.incikucuk.testapi.network.response.GetCharactersPageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {
    @GET( /* value = */ "character/{character-id}")
    suspend fun getCharacterById(
        @Path("character-id") characterId: Int
    ): Response<GetCharacterByIdResponse>

    @GET("character/")
    suspend fun getCharactersPage(
        @Query("page") pageIndex: Int
    ): Response<GetCharactersPageResponse>

    @GET("character/")
    suspend fun getCharactersPage(
        @Query("name") characterName: String,
        @Query("page") pageIndex: Int
    ): Response<GetCharactersPageResponse>
}