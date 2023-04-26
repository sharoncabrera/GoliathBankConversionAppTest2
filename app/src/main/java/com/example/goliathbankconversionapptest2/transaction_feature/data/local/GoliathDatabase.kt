package com.example.goliathbankconversionapptest2.transaction_feature.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.goliathbankconversionapptest2.transaction_feature.data.local.entities.RateEntity
import com.example.goliathbankconversionapptest2.transaction_feature.data.local.entities.TransactionEntity

@Database(
    entities = [
        TransactionEntity::class,
        RateEntity::class
    ],
    version = 1
)
abstract class GoliathDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun rateDao(): RateDao
}