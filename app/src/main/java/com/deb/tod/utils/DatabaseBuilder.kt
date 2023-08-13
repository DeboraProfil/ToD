package com.deb.tod.utils

import android.content.Context
import androidx.room.Room

class DatabaseBuilder(private val context: Context) {

    fun buildDatabase() = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        AppDatabase::class.java.simpleName
    ).fallbackToDestructiveMigration()
}