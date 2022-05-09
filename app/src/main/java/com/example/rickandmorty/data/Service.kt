package com.example.rickandmorty.data

import com.example.rickandmorty.data.APIConstants.ENDPOINT_CHARACTER
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET(ENDPOINT_CHARACTER)

    /**
     * con esta funcion capturamos todos los caracteres de una pagina
     */
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ): CharacterResponseServer
}