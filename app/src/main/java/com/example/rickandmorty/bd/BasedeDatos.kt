package com.example.rickandmorty.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [InformacionEntry::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): Dao

    companion object {

        private const val DATABASE_NAME = "rick_and_morty_db"

        @Synchronized
        fun getDatabase(context: Context): AppDatabase = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}