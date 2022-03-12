package com.example.businesscontrollv3.model

import java.math.BigDecimal

class Account (val name : String,
               val balance: BigDecimal,
               val responsible: Responsible,
               val accoutType: AccountTypeEnum
               )

