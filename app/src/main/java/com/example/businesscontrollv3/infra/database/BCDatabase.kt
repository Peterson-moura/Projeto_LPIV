package com.example.businesscontrollv3.infra.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.businesscontrollv3.model.Responsible

@Database(entities = [Responsible::class], version = 1)

abstract class BCDatabase : RoomDatabase() {
    abstract fun responsibleDao(): ResponsibleDAO

    companion object{
        @Volatile
        private var INSTANCE: BCDatabase? = null

        fun getDatabase(context: Context): BCDatabase{
            return INSTANCE?: synchronized(true){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BCDatabase::class.java,
                    "BCDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}