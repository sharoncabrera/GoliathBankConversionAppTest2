package com.example.goliathbankconversionapptest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.goliathbankconversionapptest2.core.navigation.Route
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_detail.TransactionDetailScreen
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_detail.TransactionDetailViewModel
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_list.TransactionListScreen
import com.example.goliathbankconversionapptest2.transaction_feature.presentation.transaction_list.TransactionListViewModel
import com.example.goliathbankconversionapptest2.ui.theme.GoliathBankConversionAppTest2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoliathBankConversionAppTest2Theme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.TRANSACTION_LIST
                ) {

                    composable(Route.TRANSACTION_LIST) {
                        val viewModel: TransactionListViewModel = hiltViewModel()
                        TransactionListScreen(
                            state = viewModel.state.value,
                            events = viewModel::initEvents,
                            navigateToDetailScreen = { transactionName ->
                                navController.navigate("${Route.TRANSACTION_DETAIL}/$transactionName")
                            }
                        )
                    }
                    composable(
                        route = Route.TRANSACTION_DETAIL + "/{transactionName}",
                    ) {
                        val viewModel: TransactionDetailViewModel = hiltViewModel()
                        TransactionDetailScreen(
                            state = viewModel.state.value,
                        )
                    }
                }
            }
        }
    }
}
