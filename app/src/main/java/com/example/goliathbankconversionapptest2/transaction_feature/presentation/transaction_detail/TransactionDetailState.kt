package com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_detail

import com.example.goliathbankconversionapptest2.transaction_feature.presentation.model.TransactionUIModel

data class TransactionDetailState(
    var name: String = "",
    var listTransactions: List<TransactionUIModel> = listOf(),
    var totalAmount: Double = 0.0,
    )