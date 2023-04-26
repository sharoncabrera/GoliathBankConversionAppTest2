package com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetRatesFromApiUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetTransactionsUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.util.currencyConverter
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.util.round
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionListViewModel @Inject constructor(
    private val getTransactionsUseCase: GetTransactionsUseCase,
    private val initRates: GetRatesFromApiUseCase,

    ) : ViewModel() {
    val state: MutableState<TransactionListState> = mutableStateOf(TransactionListState())

    init {
        initEvents(TransactionListEvents.GetTransactions)
    }

    fun initEvents(event: TransactionListEvents) {
        viewModelScope.launch {
            state.value = state.value.copy(transactions = getTransactionsUseCase())
            initRates()
        }
    }
}
