package com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case

import com.example.goliathbankconversionapptest2.transaction_feature.domain.repository.TransactionRepository
import javax.inject.Inject

class GetTransactionsUseCase @Inject constructor(
    private val repository: TransactionRepository
) {
    suspend operator fun invoke() = repository.getTransactions()
}