package com.example.rickandmorty.presenter

import android.content.Context
import com.example.rickandmorty.data.CharacterServer
import com.example.rickandmorty.model.PersonajeInteractor
import com.example.rickandmorty.view.PersonajeView

class PersonajePresenter(
    private var personajeView: PersonajeView?,
    private var interactor: PersonajeInteractor
) : PersonajeInteractor.FinishListener {
    override fun onResult(personaje: MutableList<CharacterServer>) {
        personajeView?.updateList(personaje)
    }

    fun getData(context: Context) {
        interactor.conexionBD(context, this)
    }
}