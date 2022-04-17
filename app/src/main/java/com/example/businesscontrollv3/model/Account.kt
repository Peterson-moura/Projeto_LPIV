package com.example.businesscontrollv3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.businesscontrollv3.model.type.AccountTypeEnum
import java.math.BigDecimal

@Entity
class Account (
    @ColumnInfo val name : String,
    @ColumnInfo val balance: Double,
    @ColumnInfo val idResponsible: Int,
    @ColumnInfo val accoutType: AccountTypeEnum
) {


    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var idAccount: Int? = null


}

