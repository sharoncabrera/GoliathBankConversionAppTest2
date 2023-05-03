package com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.components.TransactionItem


@Composable
fun TransactionListScreen(
    state: TransactionListState,
    events: (TransactionListEvents) -> Unit,
    navigateToDetailScreen: (String) -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                backgroundColor = Color.Blue,
                title = {
                    Text(
                        text = "Goliath National Bank",
                        color = Color.White,
                    )
                },
            )
        }

    ) { padding ->
        print(padding)
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                if (state.isLoading || state.transactions.isEmpty()) {
                    CircularProgressIndicator()
                    Text(text = "There are not transactions", color = Color.DarkGray)

                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center

                    ) {

                        items(state.transactions) { transactionName ->
                            TransactionItem(
                                transactionName
                            ) {
                                navigateToDetailScreen(transactionName)
                            }
                        }

                    }
                }
            }
        }
    }

}