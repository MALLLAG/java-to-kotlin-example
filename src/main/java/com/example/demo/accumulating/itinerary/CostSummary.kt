package com.example.demo.accumulating.itinerary

import com.example.demo.accumulating.money.CurrencyConversion
import com.example.demo.accumulating.money.Money

data class CostSummary(
    val lines: List<CurrencyConversion>,
    val total: Money
)