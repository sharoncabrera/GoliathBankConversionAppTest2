package com.example.goliathbankconversionapptest2.transaction_feature.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Rate

@Entity
data class RateEntity(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var from: String,
    var to: String,
    var rate: Double
)

fun RateEntity.toRate(): Rate {
    return Rate(
        from = from,
        to = to,
        rate = rate
    )
}
