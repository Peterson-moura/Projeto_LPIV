package com.example.businesscontrollv3

import android.app.Application
import com.example.businesscontrollv3.infra.database.BCDatabase

class BusinessControlApplication : Application() {

    val database by lazy {
        BCDatabase.getDatabase(this)
    }

}