package com.example.rickandmorty.utils

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.rickandmorty.R

/**
 * función para navegar entre Fragments
 */
fun Fragment.navigateTo(@NonNull directions: NavDirections) {
    lifecycleScope.launchWhenStarted {
        try {
            Navigation.findNavController(requireActivity(), R.id.fragment_container)
                .navigate(directions)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

/**
 * función para retroceder entre fragments lo utilizo para el back
 */
fun Fragment.navigateBack() {
    lifecycleScope.launchWhenStarted {
        Navigation.findNavController(requireActivity(), R.id.fragment_container)
            .popBackStack()
    }
}