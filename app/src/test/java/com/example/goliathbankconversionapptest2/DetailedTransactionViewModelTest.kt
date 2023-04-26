package com.example.goliathbankconversionapptest2

import androidx.lifecycle.SavedStateHandle
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Rate
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Transaction
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetAllTransactionUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetRatesUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_detail.TransactionDetailViewModel
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailedTransactionViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: TransactionDetailViewModel


    private var savedStateHandle: SavedStateHandle = mockk<SavedStateHandle>(relaxed = true)
    private lateinit var getRatesUseCase: GetRatesUseCase
    private lateinit var getTransactionsWithTheSameName: GetAllTransactionUseCase

    @Before
    fun setUp() {
        getTransactionsWithTheSameName = mockk(relaxed = true)
        getRatesUseCase = mockk(relaxed = true)

        every { savedStateHandle.get<String>("transactionName") } returns "TEST"

        viewModel = TransactionDetailViewModel(
            getTransactionsWithTheSameName = getTransactionsWithTheSameName,
            getRates = getRatesUseCase,
            savedStateHandle = savedStateHandle
        )
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `computeTotalAmount should correctly compute the total amount`() = runTest {

        // Given
        val transactions: List<Transaction> = listOf(
            Transaction(name = "TEST", amount = 1.0, currency = "USD"),
            Transaction(name = "TEST", amount = 2.0, currency = "EUR"),
            Transaction(name = "TEST", amount = 3.0, currency = "USD"),
        )
        val rates: List<Rate> = listOf(
            Rate(to = "EUR", from = "USD", rate = 1.0),
            Rate(to = "USD", from = "JPY", rate = 1.0)
        )
        viewModel.listTransactions.value = transactions
        viewModel.ratesList.value = rates

        // When
        viewModel.computeTotalAmount()
        advanceUntilIdle()

        // Then
        assert(6.0 == viewModel.state.value.totalAmount)
    }
}