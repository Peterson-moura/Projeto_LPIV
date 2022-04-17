package com.example.businesscontrollv3

import android.app.Application
import com.example.businesscontrollv3.infra.database.BCDatabase
import com.example.businesscontrollv3.repository.AccountRepository
import com.example.businesscontrollv3.repository.ResponsibleRepository

class BusinessControlApplication : Application() {

    val database by lazy {
        BCDatabase.getDatabase(this)
    }

    val responsibleRepository by lazy { ResponsibleRepository(database.responsibleDao()) }

    val accountRepository by lazy { AccountRepository(database.accountDao()) }


}