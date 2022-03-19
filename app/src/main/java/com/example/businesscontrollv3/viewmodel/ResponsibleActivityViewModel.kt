package com.example.businesscontrollv3.viewmodel

import android.content.Context
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.businesscontrollv3.R
import com.example.businesscontrollv3.infra.database.ResponsibleDAO
import com.example.businesscontrollv3.model.Responsible
import com.example.businesscontrollv3.repository.ResponsibleRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import java.lang.reflect.Type

class ResponsibleActivityViewModel(private val responsibleRepository: ResponsibleRepository) : BaseViewModel() {

    val allResponsibles = responsibleRepository.allResponsibles.asLiveData()

    @Bindable
    var name: String = ""

    fun saveResponsible() = viewModelScope.launch {
        val responsible = Responsible(name)

        responsibleRepository.save(responsible)
    }
}