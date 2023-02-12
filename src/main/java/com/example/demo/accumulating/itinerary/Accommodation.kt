package com.example.demo.accumulating.itinerary

import com.example.demo.accumulating.money.Money

data class Accommodation(
    val totalPrice: Money
)

fun Accommodation.costs() =
    listOf(totalPrice)