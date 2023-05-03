package com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Rate
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Transaction
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetAllTransactionUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetRatesUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.model.toUIModel
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.util.currencyConverter
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.util.round
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionDetailViewModel @Inject constructor(
    private val getRates: GetRatesUseCase,
    private val getTransactionsWithTheSameName: GetAllTransactionUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    var state by mutableStateOf(TransactionDetailState())
        private set
    var listTransactions = mutableStateOf<List<Transaction>>(emptyList())
    private val name: String? = savedStateHandle.get<String>("transactionName")

    val ratesList = mutableStateOf<List<Rate>>(emptyList())

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            name?.let {
                listTransactions.value = getTransactionsWithTheSameName(it)
                state = state.copy(
                    name = it
                )
            }
            ratesList.value = getRates()

            state = state.copy(
                listTransactions = listTransactions.value.map {
                    it.toUIModel()
                }
            )
            computeTotalAmount()
        }
    }

    fun computeTotalAmount() {
        var totalSum = 0.0
        listTransactions.value.forEach {
            val conversionRate = currencyConverter(
                rates = ratesList.value,
                currency = it.currency
            ) ?: 0.0
            totalSum += (it.amount * conversionRate)
        }

        state = state.copy(
            totalAmount = totalSum.round()
        )
    }
}