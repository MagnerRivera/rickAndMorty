package com.example.rickandmorty.data

import com.example.rickandmorty.data.APIConstants.ENDPOINT_CHARACTER
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET(ENDPOINT_CHARACTER)

    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): CharacterResponseServer
}