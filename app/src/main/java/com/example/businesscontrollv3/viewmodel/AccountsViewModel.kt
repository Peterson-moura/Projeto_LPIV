package com.example.businesscontrollv3.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.businesscontrollv3.BR
import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.Responsible
import com.example.businesscontrollv3.model.type.AccountTypeEnum
import com.example.businesscontrollv3.repository.AccountRepository
import com.example.businesscontrollv3.repository.ResponsibleRepository
import kotlinx.coroutines.launch

class AccountsViewModel(
    private val accountRepository: AccountRepository,
    private val responsibleRepository: ResponsibleRepository
) : BaseViewModel() {
    @Bindable
    var name: String = ""

    @Bindable
    var balance: String = ""

    @Bindable
    var accountTypes = AccountTypeEnum.values().map { accountTypeEnum -> accountTypeEnum.type  }

    @Bindable
    var selectedAccountTypePosition: Int = 0

    @Bindable
    var responsibleNames: List<String> = emptyList()
    set(value){
        field = value
        notifyPropertyChanged(BR.responsibleNames)
    }

    @Bindable
    var selectedResponsiblePosition: Int = 0

    lateinit var responsible: List<Responsible>

    init {
        getResponsibleNames()
    }

    fun getAccounts() = accountRepository.getAccounts()

    fun getResponsibleNames() {
        responsibleRepository.allResponsibles.asLiveData().observeForever {
            responsibleNames = it.map { responsible -> responsible.name }
            responsible = it
        }
    }

    fun formIsValid(): Boolean {
        return name.isNotBlank() && balance.isNotBlank()
    }

    fun save() {
        if (formIsValid()) {
            viewModelScope.launch {
                val accountType = AccountTypeEnum.values()[selectedAccountTypePosition]
                val responsible = responsible[selectedResponsiblePosition]
                val responsibleId = responsible.idResponsible ?: throw Exception("Id Responsible not Found")
                val account = Account(name, balance.toDouble(), responsibleId, accountType)
                accountRepository.save(account)
            }
        } else {
            //TODO: Mapear codigo de erro
        }
    }






}