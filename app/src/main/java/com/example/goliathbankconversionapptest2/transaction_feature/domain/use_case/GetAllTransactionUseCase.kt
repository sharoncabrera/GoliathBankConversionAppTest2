package com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case

import com.example.goliathbankconversionapptest2.transaction_feature.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllTransactionUseCase @Inject constructor(
    private val repository: TransactionRepository
) {
    suspend operator fun invoke(name: String) = repository.getTransactionsFromDb(name)
}