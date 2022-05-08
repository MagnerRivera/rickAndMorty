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
import com.example.rickandmorty.data.RetrofitAdapter
import com.example.rickandmorty.utils.navigateTo
import kotlinx.coroutines.launch

class Personaje : Fragment() {

    lateinit var mRecyclerView: RecyclerView
    lateinit var mAdapter: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val pag = RetrofitAdapter.apiService.getAllCharacters(1)
                mAdapter.upDateList(pag.results.toMutableList())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return inflater.inflate(R.layout.fragment_personaje, container, false)
            .apply { rootView.setUpRecyclerView() }
    }

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