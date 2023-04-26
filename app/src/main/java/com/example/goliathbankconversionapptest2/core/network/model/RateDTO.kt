package com.example.goliathbankconversionapptest2.core.network.model

import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Rate
import kotlinx.serialization.Serializable

@Serializable
data class RateDTO(
    var from: String,
    var to: String,
    var rate: Double
)

fun RateDTO.toRate(): Rate {
    return Rate(
        from = from,
        to = to,
        rate = rate
    )
}