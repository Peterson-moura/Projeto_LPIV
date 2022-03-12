package com.example.businesscontrollv3.repository

import com.example.businesscontrollv3.model.Account
import com.example.businesscontrollv3.model.AccountTypeEnum
import com.example.businesscontrollv3.model.Responsible
import java.math.BigDecimal

class AccountRepository {

    fun getALLAccounts(): MutableList<Account>{
        val responsible = Responsible("Peterson")

        return mutableListOf(
            Account("Banco 3", BigDecimal.TEN, responsible, AccountTypeEnum.DEBITO),
            Account("Banco 4", BigDecimal.valueOf(1000.00), responsible, AccountTypeEnum.DEBITO)
        )
    }
}