package com.example.rickandmorty.data

import com.example.rickandmorty.data.APIConstants.KEY_EPISODE
import com.example.rickandmorty.data.APIConstants.KEY_GENDER
import com.example.rickandmorty.data.APIConstants.KEY_ID
import com.example.rickandmorty.data.APIConstants.KEY_IMAGE
import com.example.rickandmorty.data.APIConstants.KEY_LOCATION
import com.example.rickandmorty.data.APIConstants.KEY_NAME
import com.example.rickandmorty.data.APIConstants.KEY_ORIGIN
import com.example.rickandmorty.data.APIConstants.KEY_RESULTS
import com.example.rickandmorty.data.APIConstants.KEY_SPECIES
import com.example.rickandmorty.data.APIConstants.KEY_STATUS
import com.example.rickandmorty.data.APIConstants.KEY_URL
import com.google.gson.annotations.SerializedName

data class CharacterResponseServer(
    @SerializedName(KEY_RESULTS) val results: List<CharacterServer>
)

data class CharacterServer(
    @SerializedName(KEY_ID) val id: Int,
    @SerializedName(KEY_NAME) val name: String,
    @SerializedName(KEY_IMAGE) val image: String?,
    @SerializedName(KEY_GENDER) val gender: String,
    @SerializedName(KEY_SPECIES) val species: String,
    @SerializedName(KEY_STATUS) val status: String,
    @SerializedName(KEY_ORIGIN) val origin: OriginServer,
    @SerializedName(KEY_LOCATION) val location: LocationServer,
    @SerializedName(KEY_EPISODE) val episodeList: List<String>
)

data class LocationServer(
    @SerializedName(KEY_NAME) val name: String,
    @SerializedName(KEY_URL) val url: String
)

data class OriginServer(
    @SerializedName(KEY_NAME) val name: String,
    @SerializedName(KEY_URL) val url: String
)

