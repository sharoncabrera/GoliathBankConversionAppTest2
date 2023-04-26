package com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_detail

sealed class TransactionDetailEvents {
    data class GetTransactionFromCache(
         val name: String = "",
     ) : TransactionDetailEvents()

    object GetAllTransactions : TransactionDetailEvents()

}