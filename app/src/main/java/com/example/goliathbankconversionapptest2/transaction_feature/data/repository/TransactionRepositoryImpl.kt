package com.example.goliathbankconversionapptest2.transaction_feature.data.repository

import com.example.goliathbankconversionapptest2.core.network.EndPoints
import com.example.goliathbankconversionapptest2.core.network.model.RateDTO
import com.example.goliathbankconversionapptest2.core.network.model.TransactionDTO
import com.example.goliathbankconversionapptest2.core.network.model.toRate
import com.example.goliathbankconversionapptest2.core.network.model.toTransaction
import com.example.goliathbankconversionapptest2.transaction_feature.data.local.RateDao
import com.example.goliathbankconversionapptest2.transaction_feature.data.local.TransactionDao
import com.example.goliathbankconversionapptest2.transaction_feature.data.local.entities.toRate
import com.example.goliathbankconversionapptest2.transaction_feature.data.local.entities.toTransaction
import com.example.goliathbankconversionapptest2.transaction_feature.data.mapper.toDomain
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Rate
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Transaction
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.toDomain
import com.example.goliathbankconversionapptest2.transaction_feature.domain.repository.TransactionRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient,
    private val transactionDao: TransactionDao,
    private val rateDao: RateDao,
) : TransactionRepository {
    override suspend fun getTransactions(): List<String> {
        httpClient.get {
            url(EndPoints.TRANSACTIONS_URL)
        }.body<List<TransactionDTO>>().map {
            insertTransaction(it.toTransaction())
        }
        return getTransactionsFromBD()
    }

    override suspend fun getConversionRates() {
        httpClient.get {
            url(EndPoints.CONVERSION_RATE)
        }.body<List<RateDTO>>().map {
            insertRate(it.toRate())
        }
    }

    override suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction.toDomain())
    }

    override suspend fun getTransactionsFromDb(name: String): List<Transaction> {
        return transactionDao.getAllTransactions(name).map {
            it.toTransaction()
        }
    }

    override suspend fun getTransactionById(id: Int): Transaction {
        return transactionDao.getTransactionById(id).toTransaction()
    }

    override suspend fun getTransactionsFromBD(): List<String> {
        return transactionDao.getUniqueTransaction()
    }

    override suspend fun getRatesFromBD(): List<Rate> {
        return rateDao.getRates().map {
            it.toRate()
        }
    }

    override suspend fun insertRate(rate: Rate) {
        rateDao.insertRate(rate.toDomain())
    }
}