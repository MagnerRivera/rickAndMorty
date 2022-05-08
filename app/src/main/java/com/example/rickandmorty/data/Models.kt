package com.example.rickandmorty.data

import android.os.Parcelable
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
import kotlinx.android.parcel.Parcelize

data class CharacterResponseServer(
    @SerializedName(KEY_RESULTS) val results: List<CharacterServer>
)

@Parcelize
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
): Parcelable

@Parcelize
data class LocationServer(
    @SerializedName(KEY_NAME) val name: String,
    @SerializedName(KEY_URL) val url: String
): Parcelable

@Parcelize
data class OriginServer(
    @SerializedName(KEY_NAME) val name: String,
    @SerializedName(KEY_URL) val url: String
) : Parcelable

