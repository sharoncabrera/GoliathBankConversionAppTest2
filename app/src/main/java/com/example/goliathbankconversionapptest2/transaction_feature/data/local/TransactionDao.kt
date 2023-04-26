package com.example.goliathbankconversionapptest2.transaction_feature.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.goliathbankconversionapptest2.transaction_feature.data.local.entities.TransactionEntity

@Dao
interface TransactionDao {
    @Insert
    suspend fun insertTransaction(transactionEntity: TransactionEntity)

    @Query("SELECT * FROM TransactionEntity WHERE name = :name")
    suspend fun getAllTransactions(name: String): List<TransactionEntity>

    @Query("SELECT * FROM TransactionEntity WHERE id = :id")
    suspend fun getTransactionById(id: Int): TransactionEntity

    @Transaction
    @Query("SELECT * FROM TransactionEntity")
    suspend fun getTransactions(): List<TransactionEntity>

    @Transaction
    @Query("SELECT DISTINCT name FROM TransactionEntity" )
    suspend fun getUniqueTransaction(): List<String>

}