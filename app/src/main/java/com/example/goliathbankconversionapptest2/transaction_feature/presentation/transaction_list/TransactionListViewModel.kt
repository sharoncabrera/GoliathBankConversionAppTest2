package com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetRatesFromApiUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionListViewModel @Inject constructor(
    private val getTransactionsUseCase: GetTransactionsUseCase,
    private val getRatesFromApiUseCase: GetRatesFromApiUseCase,

    ) : ViewModel() {
    var state by mutableStateOf(TransactionListState())
        private set

    init {
        initEvents(TransactionListEvents.GetTransactions)
    }

    fun initEvents(event: TransactionListEvents) {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true
            )
            state = state.copy(
                transactions = getTransactionsUseCase(),
                isLoading = false
            )
            getRatesFromApiUseCase()
        }
    }
}
