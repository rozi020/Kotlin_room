package com.example.kotlin_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

@Database(entities = arrayOf(MhsEntity::class), version = 1)
abstract class MhsDatabase: RoomDatabase() {
    abstract fun mhsDao(): MhsDao

    companion object{
        @Volatile private var instances: MhsDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instances ?: synchronized(LOCK) {
            instances ?: buildDatabase(context).also { instances = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
        MhsDatabase::class.java, "mhs.db").build()
    }
}