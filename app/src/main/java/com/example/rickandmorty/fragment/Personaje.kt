package com.example.rickandmorty.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.adapter.RecyclerAdapter
import com.example.rickandmorty.bd.AppDatabase
import com.example.rickandmorty.bd.toDatabase
import com.example.rickandmorty.bd.toDoMain
import com.example.rickandmorty.data.RetrofitAdapter
import com.example.rickandmorty.utils.navigateTo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Personaje : Fragment() {

    private lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflar el layout por el fragmento
        viewLifecycleOwner.lifecycleScope.launch {
            val database = AppDatabase.getDatabase(requireContext())
            val numPag = 1
            try {
                val pag = RetrofitAdapter.apiService.getAllCharacters(numPag)
                mAdapter.upDateList(pag.results.toMutableList())

                //mueve el hilo de la corrutina, es cambiado aqui
                //Dispatchers contexto de un hilo
                withContext(Dispatchers.IO) {
                    database.userDao().insertAll(*pag.results.map {
                        it.toDatabase(numPag)
                    }.toTypedArray())
                }
            } catch (e: Exception) {
                withContext(Dispatchers.IO) {
                    val personajesSinConexion = database.userDao().getPersonajes(numPag)
                    withContext(Dispatchers.Main) {
                        mAdapter.upDateList(personajesSinConexion.map {
                            it.toDoMain()
                        }.toMutableList())
                    }
                }
                e.printStackTrace()
            }
        }
        return inflater.inflate(R.layout.fragment_personaje, container, false)
            .apply { rootView.setUpRecyclerView() }
    }

    /**
     * funcion para navegar entre fragments con el navigateTo
     * el spanCount es para guardar 2 imagenes de personaje en una sola fila
     */
    fun View.setUpRecyclerView() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        mRecyclerView = findViewById<RecyclerView>(R.id.reciclerPersonajes)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = layoutManager
        mAdapter = RecyclerAdapter(requireContext()) {
            navigateTo(PersonajeDirections.actionPersonajeToDatosPersonaje(it))
        }
        mRecyclerView.adapter = mAdapter
    }

}