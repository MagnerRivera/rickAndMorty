package com.example.rickandmorty.view

import com.example.rickandmorty.data.CharacterServer

interface PersonajeView {

    fun updateList(personaje: MutableList<CharacterServer>)
}