package com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_detail

import com.example.goliathbankconversionapptest2.transaction_feature.presentation.model.TransactionUIModel

data class TransactionDetailState(
    val name: String = "",
    val listTransactions: List<TransactionUIModel> = listOf(),
    val totalAmount: Double = 0.0,
    )