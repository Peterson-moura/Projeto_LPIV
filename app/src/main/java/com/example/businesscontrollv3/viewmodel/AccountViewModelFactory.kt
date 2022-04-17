package com.example.businesscontrollv3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.BusinessControlApplication
import java.lang.IllegalArgumentException

class AccountViewModelFactory(private val application: BusinessControlApplication): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AccountsViewModel::class.java)){
            return AccountsViewModel(
                application.accountRepository,
                application.responsibleRepository
            ) as T
        }
        throw  IllegalArgumentException("Unknown ViewModel class")

    }


}