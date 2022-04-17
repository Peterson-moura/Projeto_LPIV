package com.example.businesscontrollv3.infra.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.Responsible
import com.example.businesscontrollv3.model.type.Converters

@Database(entities = [Responsible::class, Account::class], version = 2, exportSchema = false)
@TypeConverters(value = [Converters::class])
abstract class BCDatabase : RoomDatabase() {
    abstract fun responsibleDao(): ResponsibleDAO

    abstract  fun accountDao(): AccountDAO

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