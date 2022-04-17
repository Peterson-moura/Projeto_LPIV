package com.example.businesscontrollv3.infra.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.businesscontrollv3.model.Account
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDAO {

    @Insert
    suspend fun save(account: Account)

    @Delete
    suspend fun delete(account: Account)

    @Query("SELECT * FROM Account")
    fun getAllAccount(): Flow<List<Account>>


}