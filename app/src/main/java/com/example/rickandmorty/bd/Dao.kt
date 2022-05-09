package com.example.rickandmorty.bd

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface Dao {

    /**
     * para reemplazar un resgistro
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg personaje: InformacionEntry)


    /**
     * Consulta para traer todos los datos desde la BD
     */
    @Query("SELECT * FROM personaje WHERE pageId = :pageId")
    fun getPersonajes(pageId: Int): List<InformacionEntry>

}