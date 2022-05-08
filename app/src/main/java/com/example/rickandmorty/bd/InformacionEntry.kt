package com.example.rickandmorty.bd

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty.data.CharacterServer
import com.example.rickandmorty.data.LocationServer
import com.example.rickandmorty.data.OriginServer

@Entity(tableName = "personaje")
data class InformacionEntry(
    @PrimaryKey val id: Int,
    val name: String,
    val image: String?,
    val gender: String,
    val species: String,
    val status: String,
    @Embedded
    val origin: OriginServer,
    @Embedded
    val location: LocationServer,
    val pageId: Int
)

fun CharacterServer.toDatabase(pageId: Int) = InformacionEntry(
    id = id,
    name = name,
    image = image,
    gender = gender,
    species = species,
    status = status,
    origin = origin,
    location = location,
    pageId = pageId
)

fun InformacionEntry.toDoMain() = CharacterServer(
    id = id,
    name = name,
    image = image,
    gender = gender,
    species = species,
    status = status,
    origin = origin,
    location = location,
    episodeList = listOf()
)