package com.example.goliathbankconversionapptest2.core.network.model

import com.example.goliathbankconversionapptest2.transaction_feature.data.local.entities.TransactionEntity
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Transaction
import kotlinx.serialization.Serializable

@Serializable
data class TransactionDTO(
    var sku: String,
    var amount: Double,
    var currency: String
)

fun TransactionDTO.toTransaction(): Transaction{
    return Transaction(
        name = sku,
        amount = amount,
        currency = currency
    )
}


fun TransactionDTO.toDomain(): TransactionEntity {
    return TransactionEntity(
        id = 0,
        name = sku,
        amount = amount,
        currency = currency
    )
}