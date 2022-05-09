package com.example.rickandmorty.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.data.CharacterServer
import com.example.rickandmorty.model.PersonajeInteractor
import com.example.rickandmorty.presenter.PersonajePresenter
import com.example.rickandmorty.utils.navigateTo
import com.example.rickandmorty.view.PersonajeView
import com.example.rickandmorty.view.adapter.RecyclerAdapter

class Personaje : Fragment(), PersonajeView {

    private lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: RecyclerAdapter
    lateinit var personajePresenter: PersonajePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        personajePresenter = PersonajePresenter(this, PersonajeInteractor())
        personajePresenter.getData(requireContext())
        return inflater.inflate(R.layout.fragment_personaje, container, false)
            .apply { rootView.setUpRecyclerView() }
    }


    /**
     * se crea nueva funcion que hace la interacción con el presentador
     */
    override fun updateList(personaje: MutableList<CharacterServer>) {
        activity?.runOnUiThread {
            mAdapter.upDateList(personaje)
        }
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