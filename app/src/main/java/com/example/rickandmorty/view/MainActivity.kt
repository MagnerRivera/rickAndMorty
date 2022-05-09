package com.example.rickandmorty.view

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.utils.animAppear
import com.example.rickandmorty.utils.animVanish

class MainActivity : AppCompatActivity() {
    private lateinit var biding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)
        initSplash()
    }

    /**
     * Metodo para el splash del inicio de aplicación
     */

    private fun initSplash() {
        Handler().postDelayed({
            biding.splash.root.animVanish(this, 1000)
            despuesinit()
        }, 1000)
    }

    /**
     * metodo para mostrar los parametros de la vista despues del splash
     */

    private fun despuesinit() {
        Handler().postDelayed({
            biding.fragmentContainer.animAppear(this, 3000)
        }, 1000)
    }

}