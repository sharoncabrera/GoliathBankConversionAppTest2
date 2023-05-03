package com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_list

data class TransactionListState(
    val transactions: List<String> = listOf(),
    val transactionName: String = "",
    val isLoading: Boolean = false
)