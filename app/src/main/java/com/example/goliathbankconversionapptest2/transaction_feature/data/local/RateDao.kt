package com.example.goliathbankconversionapptest2.transaction_feature.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.goliathbankconversionapptest2.transaction_feature.data.local.entities.RateEntity

@Dao
interface RateDao {
    @Insert
    suspend fun insertRate(RateEntity: RateEntity)

    @Query("SELECT * FROM RateEntity")
    suspend fun getRates(): List<RateEntity>


}