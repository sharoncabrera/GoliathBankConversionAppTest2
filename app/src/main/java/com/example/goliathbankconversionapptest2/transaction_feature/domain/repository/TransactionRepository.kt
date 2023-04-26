package com.example.goliathbankconversionapptest2.transaction_feature.domain.repository

import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Rate
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Transaction

interface TransactionRepository {
    suspend fun getTransactions(): List<String>
    suspend fun getConversionRates()

    suspend fun insertTransaction(transaction: Transaction)
    suspend fun getTransactionsFromDb(name: String): List<Transaction>
    suspend fun getTransactionById(id: Int): Transaction
    suspend fun getTransactionsFromBD(): List<String>

    suspend fun getRatesFromBD(): List<Rate>
    suspend fun insertRate(rate: Rate)
}