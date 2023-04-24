package com.example.demo.openToSealed.itinerary

import com.example.demo.openToSealed.Id
import com.example.demo.openToSealed.geo.OverlayGroup

data class Itinerary(
    val id: Id<Itinerary>,
    val items: List<ItineraryItem>
) : Iterable<ItineraryItem> by items

val Itinerary.mapOverlay: OverlayGroup
    get() = OverlayGroup(
        id = id,
        elements = items.map { it.mapOverlay }
    )

val Itinerary.costs
    get() = flatMap(ItineraryItem::costs)
