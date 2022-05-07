package com.example.rickandmorty.utils

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import com.example.rickandmorty.R

/**EXTENSION PARA MOSTRAR UNA VIEW CON UNA ANIMACIÓN
 * @param context
 * @param duration duración de cuanto tiempo va a tardar la animacion
 * */
fun View.animAppear(context: Context, duration: Int) {
    val animations      = AnimationUtils.loadAnimation(context, R.anim.anim_appear)
    animations.duration = duration.toLong()

    this.visibility     = View.VISIBLE
    this.animation      = animations
}
/**EXTENSION PARA OCULTAR UNA VIEW CON UNA ANIMACIÓN
 * @param context
 * @param duration duracion de cuanto tiempo va a tardar la animacion
 * */
fun View.animVanish(context: Context, duration: Int) {
    val animations      = AnimationUtils.loadAnimation(context, R.anim.anim_vanish)
    animations.duration = duration.toLong()

    this.visibility     = View.GONE
    this.animation      = animations
}