package com.example.demo.accumulating.itinerary

typealias Route = List<Journey>

fun Route.costs() = map { it.price }