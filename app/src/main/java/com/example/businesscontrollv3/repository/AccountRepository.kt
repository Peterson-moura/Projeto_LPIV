package com.example.businesscontrollv3.repository

import androidx.annotation.WorkerThread
import com.example.businesscontrollv3.infra.database.AccountDAO
import com.example.businesscontrollv3.model.Account

class AccountRepository(private val accoutDAO: AccountDAO ) {

    fun getAccounts() = accoutDAO.getAllAccount()

    @WorkerThread
    suspend fun  save(account: Account){
        accoutDAO.save(account)
    }

    suspend fun deleteAccout(account: Account){
        this.accoutDAO.delete(account)
    }

}