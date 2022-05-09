package com.example.rickandmorty.model

import android.content.Context
import com.example.rickandmorty.bd.AppDatabase
import com.example.rickandmorty.bd.toDatabase
import com.example.rickandmorty.bd.toDoMain
import com.example.rickandmorty.data.CharacterServer
import com.example.rickandmorty.data.RetrofitAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PersonajeInteractor {
    val scope = CoroutineScope(Job() + Dispatchers.Main)

    /**
     * Se implementa la interfas que trate las caracteristicas
     */
    interface FinishListener {
        fun onResult(personaje: MutableList<CharacterServer>)
    }

    /**
     * Esta es la funcion que muestra los personajes del API almacenados en la BD
     * Esta funcion sirve con o sin WiFi, trae los datos ya que estan almacenados en la BD
     */
    fun conexionBD(context: Context, finishListener: FinishListener) {
        scope.launch {
            val database = AppDatabase.getDatabase(context)
            val numPag = 1
            try {
                val pag = RetrofitAdapter.apiService.getAllCharacters(numPag)
                finishListener.onResult(pag.results.toMutableList())

                //mueve el hilo de la corrutina, es cambiado aqui
                //Dispatchers contexto de un hilo
                Thread {
                    database.userDao().insertAll(*pag.results.map {
                        it.toDatabase(numPag)
                    }.toTypedArray())
                }.start()
            } catch (e: Exception) {
                Thread {
                    val personajesSinConexion = database.userDao().getPersonajes(numPag)
                    finishListener.onResult(personajesSinConexion.map {
                        it.toDoMain()
                    }.toMutableList())
                }.start()
                e.printStackTrace()
            }
        }
    }
}
