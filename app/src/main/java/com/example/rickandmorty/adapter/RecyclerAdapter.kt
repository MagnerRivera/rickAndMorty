package com.example.rickandmorty.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.data.CharacterServer
import com.squareup.picasso.Picasso

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolderPersonaje>() {

    var personajes: MutableList<CharacterServer> = ArrayList()
    lateinit var context: Context

    fun RecyclerAdapter(context: Context) {
        this.context = context
    }

    @SuppressLint("NotifyDataSetChanged")
    fun upDateList(personaje: MutableList<CharacterServer>){
        this.personajes = personaje
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolderPersonaje, position: Int) {
        val item = personajes.get(position)
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolderPersonaje {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderPersonaje(layoutInflater.inflate(R.layout.item_personaje, parent, false))
    }

    override fun getItemCount(): Int {
        return personajes.size
    }

    class ViewHolderPersonaje(view: View) : RecyclerView.ViewHolder(view) {
        val nombre = view.findViewById(R.id.nombre) as TextView
        val especie = view.findViewById(R.id.especie) as TextView
        val status = view.findViewById(R.id.status) as TextView
        val avatar = view.findViewById(R.id.ivAvatar) as ImageView

        fun bind(re: CharacterServer, context: Context) {
            nombre.text = re.name
            especie.text = re.species
            status.text = re.status
            itemView.setOnClickListener(View.OnClickListener {
                Toast.makeText(
                    context,
                    re.image,
                    Toast.LENGTH_SHORT
                ).show()
            })
            re.image?.let { avatar.loadUrl(it) }
        }

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }
}