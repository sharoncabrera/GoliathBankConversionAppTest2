package com.example.goliathbankconversionapptest2.transaction_feature.domain.model

import com.example.goliathbankconversionapptest2.transaction_feature.data.local.entities.RateEntity

data class Rate(
    var from: String,
    var to: String,
    var rate: Double
)


fun Rate.toDomain(): RateEntity {
    return RateEntity(
        id = 0,
        from = from,
        to = to,
        rate = rate
    )
}