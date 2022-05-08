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

    @Query("SELECT * FROM personaje WHERE pageId = :pageId")
    fun getPersonajes(pageId: Int): List<InformacionEntry>

}