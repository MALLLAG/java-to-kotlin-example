package com.example.demo.openToSealed.itinerary

import com.example.demo.openToSealed.money.Money

val ItineraryItem.costs: List<Money>
    get() = when (this) {
        is Accommodation -> listOf(totalPrice)
        is Attraction -> emptyList()
        is Journey -> listOf(price)
        is RestaurantBooking -> emptyList()
    }

