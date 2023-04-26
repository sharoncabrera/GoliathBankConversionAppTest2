package com.example.goliathbankconversionapptest2.transaction_feature.data.mapper

import com.example.goliathbankconversionapptest2.transaction_feature.data.local.entities.TransactionEntity
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Transaction

fun Transaction.toDomain(): TransactionEntity {
    return TransactionEntity(
        id = 0,
        name = name,
        amount = amount,
        currency = currency
    )
}