package com.example.rickandmorty.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.rickandmorty.R
import com.example.rickandmorty.utils.navigateBack
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
        val identificador = view.findViewById(R.id.id) as TextView
        val nombre = view.findViewById(R.id.nombre) as TextView
        val gender = view.findViewById(R.id.gender) as TextView
        val especie = view.findViewById(R.id.especie) as TextView
        val status = view.findViewById(R.id.status) as TextView
        val origin = view.findViewById(R.id.origin) as TextView
        val location = view.findViewById(R.id.location) as TextView
        val avatar = view.findViewById(R.id.ivAvatar) as ImageView
        val back = view.findViewById(R.id.back) as ImageView

        back.setOnClickListener {
            navigateBack()
        }

        identificador.inputType = re.id
        nombre.text = re.name
        gender.text = re.gender
        especie.text = re.species
        status.text = re.status
        origin.text = re.origin.name
        location.text = re.location.name
        re.image?.let { avatar.loadUrl(it) }
        return inflate
    }

    /**
     * función para traer la imagen por medio de la Url
     */
    fun ImageView.loadUrl(url: String) {
        Picasso.with(context).load(url).into(this)
    }
}