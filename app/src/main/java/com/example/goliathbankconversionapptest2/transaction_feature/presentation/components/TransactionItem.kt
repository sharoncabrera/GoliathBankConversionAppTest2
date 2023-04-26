package com.example.goliathbankconversionapptest2.transaction_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Transaction

@Composable
fun TransactionItem(
    transactionName: String,
    onClick: () -> Unit,
) {
    Card(
        elevation = 15.dp,
        modifier = Modifier
            .fillMaxWidth(0.95f)
            .fillMaxHeight(0.8f)
            .clickable {
                onClick()
            }
            .padding(top = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .height(100.dp)
                .background(Color.White)
        ) {
            Column {
                Text(
                    text = transactionName,
                    color = Color.DarkGray,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, start = 10.dp)
                )
            }
        }
    }
}