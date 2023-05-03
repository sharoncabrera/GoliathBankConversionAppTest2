package com.example.goliathbankconversionapptest2

import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetRatesFromApiUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.domain.use_case.GetTransactionsUseCase
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_list.TransactionListEvents
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_list.TransactionListViewModel
import io.mockk.Runs
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.just
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TransactionListViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: TransactionListViewModel

    private lateinit var getTransactionsUseCase: GetTransactionsUseCase

    private lateinit var getRatesFromApiUseCase: GetRatesFromApiUseCase

    @Before
    fun setUp() {
        getTransactionsUseCase = mockk(relaxed = true)
        getRatesFromApiUseCase = mockk(relaxed = true)
        viewModel = TransactionListViewModel(getTransactionsUseCase, getRatesFromApiUseCase)
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `initEvents should update state with transactions and initialize rates`() = runTest {

        val transactions = listOf("NAME-TEST")
        coEvery { getTransactionsUseCase() } returns transactions
        coEvery { getRatesFromApiUseCase() } just Runs

        // When
        viewModel.initEvents(TransactionListEvents.GetTransactions)

        // Then
        coVerify { getTransactionsUseCase() }
        coVerify {
            getRatesFromApiUseCase()
        }
        advanceUntilIdle()
        assertEquals(transactions, viewModel.state.transactions)
    }


}