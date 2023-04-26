package com.example.goliathbankconversionapptest2.transaction_feature.presentation.util

import com.example.goliathbankconversionapptest2.transaction_feature.domain.model.Rate
import java.math.RoundingMode

fun currencyConverter(
    rates: List<Rate>,
    currency: String,
    amount: Double = 1.0,
    visited: Set<String> = emptySet(),
    toCurrency: String = "EUR"
): Double? {
    rates.firstOrNull { it.from == currency && it.to == toCurrency }?.let {
        return amount * it.rate
    }
    rates.firstOrNull { it.to == currency && it.from == toCurrency }?.let {
        return amount / it.rate
    }

    if (currency == toCurrency) {
        return amount
    }

    val newVisited = visited.plus(currency)
    rates.forEach { rate ->
        if (currency == rate.from && !visited.contains(rate.to)) {
            return currencyConverter(rates, rate.to, amount * rate.rate, newVisited)
        } else if (currency == rate.to && !visited.contains(rate.from)) {
            return currencyConverter(rates, rate.from, amount / rate.rate, newVisited)
        }
    }
    return null
}


fun Double.round(): Double {
    return this.toBigDecimal()
        .setScale(2, RoundingMode.HALF_UP)
        .toDouble()
}
