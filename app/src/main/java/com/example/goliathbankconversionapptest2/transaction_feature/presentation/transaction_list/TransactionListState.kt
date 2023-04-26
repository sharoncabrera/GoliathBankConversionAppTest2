package com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_list

data class TransactionListState(
    var transactions: List<String> = listOf(),
    val transactionName: String = "",
)