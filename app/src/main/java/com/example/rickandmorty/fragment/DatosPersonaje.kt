package com.example.rickandmorty.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.rickandmorty.R
import com.squareup.picasso.Picasso


class DatosPersonaje : Fragment() {
    val args: DatosPersonajeArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_datos_personaje, container, false)
        val view = inflate.rootView
        val re = args.personaje
        val nombre = view.findViewById(R.id.nombre) as TextView
        val especie = view.findViewById(R.id.especie) as TextView
        val status = view.findViewById(R.id.status) as TextView
        val avatar = view.findViewById(R.id.ivAvatar) as ImageView

        nombre.text = re.name
        especie.text = re.species
        status.text = re.status
        re.image?.let { avatar.loadUrl(it) }
        return inflate
    }

    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }
}