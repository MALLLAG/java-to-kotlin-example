package com.example.demo.nullability

import java.time.Duration

class Leg private constructor(
    val description: String,
    val plannedDuration: Duration
) {

    companion object {
        fun leg(name: String, duration: Duration): Leg {
            return Leg(name, duration)
        }
    }
}