package com.example.demo.nullability

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test
import java.time.Duration
import java.util.List

class LongestLegOverTests {

    private val legs = List.of(
        Leg.leg("one hour", Duration.ofHours(1)),
        Leg.leg("one day", Duration.ofDays(1)),
        Leg.leg("two hours", Duration.ofHours(2))
    )
    private val oneDay = Duration.ofDays(1)

    @Test
    fun `is absent when no legs`() {
        assertNull(emptyList<Leg>().longestOver(Duration.ZERO))
    }

    @Test
    fun `is absent when no legs long enough`() {
        assertNull(legs.longestOver(oneDay))
    }

    @Test
    fun `is longest leg when one match`() {
        assertEquals(
            "one day",
            legs.longestOver(oneDay.minusMillis(1))
                !!.description
        )
    }

    @Test
    fun `is longest leg when more than one match`() {
        assertEquals(
            "one day",
            legs.longestOver(Duration.ofMinutes(59))
                ?.description
        )
    }
}