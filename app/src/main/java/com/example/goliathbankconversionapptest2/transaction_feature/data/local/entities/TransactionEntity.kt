package com.example.goliathbankconversionapptest2.transaction_feature.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Transaction

@Entity
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var name: String,
    var amount: Double,
    var currency: String
)

fun TransactionEntity.toTransaction(): Transaction {
    return Transaction(
        name = name,
        amount = amount,
        currency = currency
    )
}
