package com.example.goliathbankconversionapptest2.transaction_feature.presentation.model

import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Transaction
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.util.round

data class TransactionUIModel(
    var amount: String,
    var currency: String
)

fun Transaction.toUIModel(): TransactionUIModel {
    return TransactionUIModel(amount = amount.round().toString(),currency = currency)
}