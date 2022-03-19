package com.example.businesscontrollv3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.BusinessControlApplication
import com.example.businesscontrollv3.repository.ResponsibleRepository
import com.example.businesscontrollv3.view.ResponsibleActivity

class ResponsibleViewModelFactory(private val application: BusinessControlApplication) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResponsibleActivityViewModel::class.java)) {
            val responsibleDAO = application.database.responsibleDao()
            val responsibleRespository = ResponsibleRepository(responsibleDAO)

            return ResponsibleActivityViewModel(responsibleRespository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}