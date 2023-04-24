package com.example.demo.openToSealed

import com.example.demo.openToSealed.geo.Position

data class Location(
    val id: Id<Location>,
    val localName: String,
    val userReadableName: String,
    val position: Position
)
