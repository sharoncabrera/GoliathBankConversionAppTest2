package com.example.goliathbankconversionapptest2.core.network

object EndPoints {
    private const val BASE_URL = "https://android-ios-service.herokuapp.com"
    const val TRANSACTIONS_URL = "$BASE_URL/transactions"
    const val CONVERSION_RATE = "$BASE_URL/rates"
}