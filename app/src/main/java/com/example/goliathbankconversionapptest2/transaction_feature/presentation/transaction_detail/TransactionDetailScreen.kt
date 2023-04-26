package com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.components.DetailedTransactionItem

@Composable
fun TransactionDetailScreen(
    state: TransactionDetailState,
) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.White),
    ) {
        Text(
            modifier = Modifier.padding(bottom = 15.dp, start = 5.dp, top = 20.dp),
            text = "Transactions:", color = Color.Red,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Divider()

        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            items(state.listTransactions) { item ->
                DetailedTransactionItem(item)
            }
        }

        Divider()

        Text(
            modifier = Modifier.padding(top = 20.dp, start = 5.dp, bottom = 10.dp),
            text = "Total sum in EUR for ${state.name} is:",
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 20.sp),
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.padding(top = 20.dp, start = 5.dp, bottom = 10.dp),
            text = "${state.totalAmount} €",
            color = Color.DarkGray,
            fontWeight = FontWeight.Bold,
            style = TextStyle(fontSize = 25.sp)
        )

    }
}

