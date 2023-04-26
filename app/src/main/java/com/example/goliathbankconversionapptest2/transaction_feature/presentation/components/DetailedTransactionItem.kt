package com.example.goliathbankconversionapptest2.transaction_feature.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.model.TransactionUIModel

@Composable
fun DetailedTransactionItem(transaction: TransactionUIModel) {
    Box {
        Row(
            modifier = Modifier
                .padding(5.dp)
        ) {
            Column(
            ) {
                Text(
                    text = "Amount",
                    color = Color.Blue
                )
                Text(
                    text = transaction.amount,
                    color = Color.DarkGray
                )
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = "Currency",
                    color = Color.Blue
                )
                Text(
                    text = transaction.currency,
                    color = Color.DarkGray
                )
            }
        }
        Divider()
    }
}